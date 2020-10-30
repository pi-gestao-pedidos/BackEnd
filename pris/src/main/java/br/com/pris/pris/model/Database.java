package br.com.pris.pris.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
	private static Map<String, List<Object>> database = new HashMap<>();
	private static List<Object> despesa = new ArrayList<>();
	private static List<Object> despesa_produto = new ArrayList<>();
	private static List<Object> dias_da_semana = new ArrayList<>();
	private static List<Object> endereco = new ArrayList<>();
	private static List<Object> material = new ArrayList<>();
	private static List<Object> pedido = new ArrayList<>();
	private static List<Object> perfil_cliente = new ArrayList<>();
	private static List<Object> produto = new ArrayList<>();
	private static List<Object> telefone = new ArrayList<>();
	
	public Database() {
		database.put("despesa",despesa);
		database.put("despesa_produto",despesa_produto);
		database.put("dias_da_semana",dias_da_semana);
		database.put("endereco",endereco);
		database.put("material",material);
		database.put("pedido",pedido);
		database.put("perfil_cliente",perfil_cliente);
		database.put("produto",produto);
		database.put("telefone",telefone);
	}
	
	public void save(String tabela, Object obj) {
		database.get(tabela).add(obj);
	}
	
	public List<Object> list(String tabela){
		return database.get(tabela);
	}
}
