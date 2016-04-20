package org.test

import spark.ModelAndView
import spark.template.velocity.VelocityTemplateEngine

import javax.servlet.MultipartConfigElement
import javax.servlet.http.Part

import static spark.Spark.*

class Main {


    static doWork(InputStream inStream){
        println inStream.text
    }

    static void main(String[] args){
        staticFileLocation("/static")
        post("/upload", { req, res ->
            MultipartConfigElement multipartConfigElement = new MultipartConfigElement(System.getProperty('java.io.tmpdir'))
            req.raw().setAttribute('org.eclipse.jetty.multipartConfig', multipartConfigElement)

            Part part = req.raw().getPart('file')

            doWork(part.getInputStream())
            new ModelAndView([name: 'hilario'], "hello.vm")
        }, new VelocityTemplateEngine())
    }

}
