/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProdutosDAO {
    private conectaDAO conectaDAO;
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
 
   
     public ProdutosDAO() {
     this.conectaDAO = new conectaDAO();
     this.conn = this.conectaDAO.connectDB();
}
        

     public void inserir (ProdutosDTO produtos) {
     String sql = "INSERT INTO produtos(id, nome, valor, status) VALUES (?, ?, ?, ?)";
     try { 
         PreparedStatement stmt = this.conn.prepareStatement(sql);
         stmt.setInt(1, produtos.getId());
         stmt.setString(2, produtos.getNome());
         stmt.setInt(3, produtos.getValor());
         stmt.setString(4, produtos.getStatus());
         stmt.execute();
         
         
        } catch(Exception e) {
            System.out.println("Erro ao inserir produto" + e.getMessage());
        } }
     
    
       public void excluir (int id) {
     String sql = "DELETE FROM produtos WHERE id = ?";
     try { 
         PreparedStatement stmt = this.conn.prepareStatement(sql);
         stmt.setInt(1, id);
         stmt.execute();
        
        } catch(Exception e) {
            System.out.println("Erro ao excluir produto" + e.getMessage());
        } }
     
    
    
    
        
}

