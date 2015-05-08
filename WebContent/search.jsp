<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="de.uniwue.cs.ir.vsr.*" %>
<%@ page import="de.uniwue.cs.ir.common.*" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.util.Collection" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Gefundene Dokumente</h1>
<ul>
<%
  	CorpusImpl corpus = new CorpusImpl();
	
	//Alle Texte Einlesen
	File dir = Config.getCorpusDir();
	for (File file : dir.listFiles()) {
		if (!file.isDirectory()) {
			FileInputStream stream = new FileInputStream(file);
			IDocument doc = new DocumentImpl(file.getName());
			doc.read(stream);
			stream.close();
			corpus.addDocument(doc);
		}
	}
	
	String eingabe = request.getParameter("suche");
	
	String[] terme = eingabe.split(",");
	
	String suchmethode = request.getParameter("suchmethode");
	Collection<IDocument> docs;
	
	out.println(suchmethode);
	
	if("OR".equals(suchmethode)){
		docs = corpus.getDocumentsContainingAny(terme);
	}else{
		docs = corpus.getDocumentsContainingAll(terme);
	}
	
	for(IDocument doc : docs){
		out.println("<li>"+doc.getId()+"</li>");
	}
	
	
  	%>
  	
	<li><a href="index.jsp">Zurück</a>
</ul>
</body>
</html>