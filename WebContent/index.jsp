<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- Definiere Attribute, die für die ganze Seite gelten -->
<%@page import="de.uniwue.cs.ir.vsr.IDocument"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1" %>
<%@ page isELIgnored="false" %>    

<!-- Nutze jstl core Bibliothek -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   
    <link rel="stylesheet" type="text/css" href="theme/style.css"/>
   
    <title>IR-Suchmaschine</title>
  </head>
  
  <h1>IR-Suchmaschine</h1>
  <ul>
  	<li><a href="1loesung/index.jsp">Lösung 1</a></li>
  	<form action="search.jsp" method="POST">
  	<li>Suchoption:
  	<fieldset>
    <input type="radio" name="suchmethode" value="AND"><label> AND</label>
    <input type="radio" name="suchmethode" value="OR"><label>  OR</label>  
	  </fieldset>
	  </li>
  	<li>
	  	
		Text (Terme müssen mit ',' getrennt werden!):
		<input type="text" name="suche">
		<input type="submit" value="Suchen">
		</form>
  	</li>
  </ul>
</html>