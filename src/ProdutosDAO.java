

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
     String sql = "INSERT INTO produtos2(nome, valor, status) VALUES (?, ?, ?)";
     try { 
         PreparedStatement stmt = this.conn.prepareStatement(sql);
         stmt.setString(1, produtos.getNome());
         stmt.setInt(2, produtos.getValor());
         stmt.setString(3, produtos.getStatus());
         stmt.execute();
         
         
        } catch(Exception e) {
            System.out.println("Erro ao inserir produto" + e.getMessage());
        } }
     
    
       public void excluir (int id) {
     String sql = "DELETE FROM produtos2 WHERE id = ?";
     try { 
         PreparedStatement stmt = this.conn.prepareStatement(sql);
         stmt.setInt(1, id);
         stmt.execute();
        
        } catch(Exception e) {
            System.out.println("Erro ao excluir produto" + e.getMessage());
        } }
     
    
   
    public List<ProdutosDTO> getProdutos() {
         String sql = "SELECT * FROM produtos2";
           try { 
         PreparedStatement stmt = this.conn.prepareStatement(sql);
         ResultSet r = stmt.executeQuery();
         
         List<ProdutosDTO> listaDutos = new ArrayList<>();
         
         while (r.next()) {
             ProdutosDTO produtos = new ProdutosDTO();
          produtos.setId(r.getInt("id"));
          produtos.setNome(r.getString("nome"));
          produtos.setStatus(r.getString("status"));
          produtos.setValor(r.getInt("valor"));
          
         listaDutos.add(produtos);
             
         } return listaDutos;
         
        
        } catch(Exception e) {
            System.out.println("Erro:" + e.getMessage());
            return null; 
        } 
     }
     }
     
        


