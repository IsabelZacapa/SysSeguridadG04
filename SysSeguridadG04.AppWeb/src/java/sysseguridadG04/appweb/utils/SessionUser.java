/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sysseguridadG04.appweb.utils;

/**
 *
 * @author Isabel
 */

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import sysseguridadg04.entidadesdenegocio.Usuario;

public class SessionUser {
    public static void autenticarUser(HttpServletRequest request, Usuario pUsuario)
    {
        HttpSession session = (HttpSession) request.getSession();
        session.setMaxInactiveInterval(3600);
        session.setAttribute("auth", true);
        session.setAttribute("user", pUsuario.getLogin());
        session.setAttribute("rol", pUsuario.getRol().getNombre());
    }
    
    public static boolean isAuth(HttpServletRequest request)
    {
        HttpSession session = (HttpSession) request.getSession();
        boolean auth = session.getAttribute("auth")!= null?
                (boolean) session.getAttribute("auth") : false;
        return auth;
    }
    
    public static String getUser(HttpServletRequest request)
    {
        HttpSession session = (HttpSession) request.getSession();
        String user = "";
        if(SessionUser.isAuth(request))
        {
            user = session.getAttribute("user") != null?
                    (String) session.getAttribute("user") : "";
        }
        return user;
    }
    
    public static String getRol(HttpServletRequest request)
    {
        HttpSession session = (HttpSession) request.getSession();
        String rol = "";
        if(SessionUser.isAuth(request))
        {
            rol = session.getAttribute("rol") != null?
                    (String) session.getAttribute("rol") : "";
        }
        return rol;
    }
    
    
    
            
}
