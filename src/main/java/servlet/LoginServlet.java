package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        res.setContentType("text/html");      
        PrintWriter out = res.getWriter(); 
        out.println("<h1>Questa non e' ibiza</h1>");




        /*int vocaboli=d.lenght();
        res.setContentType("text/html");      
        PrintWriter out = res.getWriter(); 
        out.println("<h1>Dizionario dei sinonimi e dei contrari</h1>");
        if(mod.equals("cerca")){
            String termine = req.getParameter("termine").toLowerCase();
            String tipologia = req.getParameter("tipologia");
            String risultato = d.trova(termine, tipologia);
            out.println("<h3>Risultato ricerca:</h3>");     
            out.println("<p>Termine ricercato: " + termine +" Tipologia ricerca: " + tipologia + "</p>");
            out.println("<p>Risultato ricerca: "+ risultato + "</p>");
        }
        if(mod.equals("aggiungi")){
            String termine = req.getParameter("termine").toLowerCase();
            String sinonimi = req.getParameter("sinonimi").toLowerCase();
            String contrari = req.getParameter("contrari").toLowerCase();
            d.add(termine,sinonimi,contrari);
            vocaboli++;
            out.println("<h3>Termine inserito</h3>");

		}
		if(mod.equals("modifica")){
			String termine = req.getParameter("termine").toLowerCase();
            String sinonimi = req.getParameter("sinonimi").toLowerCase();
			String contrari = req.getParameter("contrari").toLowerCase();
			if(d.modifica(termine, sinonimi, contrari)){;
			out.println("<h3>modifica completata</h3>");
			}else{
				out.println("<h3>Termine non trovato</h3>");
			}
		}
		if(mod.equals("elimina")){
			String termine = req.getParameter("termine").toLowerCase();
			if(d.elimina(termine)){
				vocaboli--;
				out.println("<h3>Termine eliminato</h3>");
			}else{
				out.println("<h3>Termine non trovato</h3>");
			}
		}
        out.println("<p>Numero di vocaboli presenti nel dizionario: "+vocaboli + "</p>");
        out.println("<a href='http://localhost:8080/WebContent'>link home</a>");*/
	}

}
