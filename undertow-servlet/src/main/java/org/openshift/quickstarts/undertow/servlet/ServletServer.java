/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2014 Red Hat, Inc., and individual contributors
 * as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.openshift.quickstarts.undertow.servlet;

import java.util.HashMap;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.handlers.PathHandler;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;

import static io.undertow.servlet.Servlets.defaultContainer;
import static io.undertow.servlet.Servlets.deployment;
import static io.undertow.servlet.Servlets.servlet;

import io.undertow.servlet.test.util.TestClassIntrospector;
import io.undertow.servlet.test.util.TestResourceLoader;

import io.undertow.server.handlers.resource.ClassPathResourceManager;
import io.undertow.server.handlers.resource.PathResourceManager;
import io.undertow.server.handlers.resource.FileResourceManager;
import io.undertow.servlet.api.ServletContainer;
import io.undertow.servlet.api.ServletInfo;

import io.undertow.jsp.HackInstanceManager;
import io.undertow.jsp.JspServletBuilder;
import io.undertow.jsp.JspFileHandler;

import org.apache.jasper.deploy.JspPropertyGroup;
import org.apache.jasper.deploy.TagLibraryInfo;
import org.apache.jasper.servlet.JspServlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;

/**
 * @author Stuart Douglas
 */
public class ServletServer {

    public static final String MYAPP = "/";

    public static void main(final String[] args) {
        try {
            /*
            DeploymentInfo servletBuilder = deployment()
            .setClassLoader(ServletServer.class.getClassLoader())
            .setContextPath("/servlet")
            .setDeploymentName("myservlet.war")
            .addServlets(                
                servlet("MessageServlet", MessageServlet.class)
                    .addInitParam("message", "Hello World")
                    .addMapping("/*"),
                servlet("MyServlet", MessageServlet.class)
                    .addInitParam("message", "MyServlet")
                    .addMapping("/myservlet"),
                servlet("LoginServlet", servlet.LoginServlet.class)                    
                    .addMapping("/LoginServlet")
                    );
            */

            DeploymentInfo jspBuilder = deployment()
                .setClassLoader(ServletServer.class.getClassLoader())
                .setContextPath("/")
                //.setClassIntrospecter(TestClassIntrospector.INSTANCE)
                .setDeploymentName("myjsp.war")
                //.setResourceManager(new PathResourceManager(Paths.get(System.getProperty("user.home"))))
                .setResourceManager(new DefaultResourceLoader(ServletServer.class))
                .addServlet(JspServletBuilder.createServlet("Default Jsp Servlet", "*.jsp"))
                .addServlets(
                    /*                
                    servlet("MessageServlet", MessageServlet.class)
                        .addInitParam("message", "Hello World")
                        .addMapping("/*"),
                    servlet("MyServlet", MessageServlet.class)
                        .addInitParam("message", "MyServlet")
                        .addMapping("/myservlet"),
                    */
                    servlet("LoginServlet", servlet.LoginServlet.class)                    
                        .addMapping("/LoginServlet")
                );
                /*
                .addServlet(new ServletInfo("jsp-index", JspServlet.class)
                    .addHandlerChainWrapper(JspFileHandler.jspFileHandlerWrapper("/index.jsp"))
                    .addMapping("/"));
                */
            
            HashMap<String, TagLibraryInfo> tagLibraryInfo = TldLocator.createTldInfos();
            JspServletBuilder.setupDeployment(jspBuilder, new HashMap<String, JspPropertyGroup>(), tagLibraryInfo, new HackInstanceManager());

            //DeploymentManager manager = defaultContainer().addDeployment(servletBuilder);

            //manager.deploy();

            //final ServletContainer container = ServletContainer.Factory.newInstance();

            DeploymentManager jspManager = defaultContainer().addDeployment(jspBuilder);            

            jspManager.deploy();

            PathHandler path = Handlers.path(/* Handlers.redirect("/index.jsp") */)
                    //.addPrefixPath(servletBuilder.getContextPath(), manager.start())
                    .addPrefixPath(jspBuilder.getContextPath(), jspManager.start());

            SSLContext sslContext = null;
            String filename = System.getenv("HTTPS_KEYSTORE");
            if (filename != null) {
                String directory = System.getenv("HTTPS_KEYSTORE_DIR");
                char[] password = System.getenv("HTTPS_PASSWORD").toCharArray();
                File keystore = new File(directory, filename);
            
                sslContext = createSSLContext(loadKeyStore(keystore, password), password);
            }
            
            //HttpHandler servletHandler = manager.start();

            //PathHandler path = Handlers.path(Handlers.redirect(MYAPP))
            //        .addPrefixPath(MYAPP, servletHandler);

            Undertow server = Undertow.builder()
                    .addHttpListener(8080, "0.0.0.0")
                    .addHttpsListener(8443, "0.0.0.0", sslContext)
                    .setHandler(path)                    
                    .build();

            server.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    private static KeyStore loadKeyStore(File file, char[] password) throws Exception {
        final InputStream stream = new FileInputStream(file);
        try(InputStream is = stream) {
            KeyStore loadedKeystore = KeyStore.getInstance("JKS");
            loadedKeystore.load(is, password);
            return loadedKeystore;
        }
    }

    private static SSLContext createSSLContext(final KeyStore keyStore, final char[] password) throws Exception {
        KeyManager[] keyManagers;
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, password);
        keyManagers = keyManagerFactory.getKeyManagers();

        SSLContext sslContext;
        sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagers, null, null);

        return sslContext;
    }

    public static class DefaultResourceLoader extends ClassPathResourceManager {
        public DefaultResourceLoader(final Class<?> clazz) {
            super(clazz.getClassLoader(), "webapp");
        }
    }
}
