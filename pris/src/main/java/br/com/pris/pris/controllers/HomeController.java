package br.com.pris.pris.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping(method = RequestMethod.GET, path = "/")
	public String home() {
		return ""
				+ "<style>"
				+ "body {\n" + 
				"    background-color: #1E2B36;\n" + 
				"    color: #F3F3F7;\n" + 
				"    font-family: \"Roboto\", Arial, Helvetica, sans-serif;\n" + 
				"    display: flex;\n" + 
				"    justify-content: center;\n" + 
				"    align-items: center;\n" + 
				"}</style>"
				+ "<h1>PRIS API</h1>";
	}
}
