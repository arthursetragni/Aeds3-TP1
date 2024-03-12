import java.io.File;

public class Principal {

  public static void main(String[] args) {

    new File("dados/livros.db").delete();
    new File("dados/livros.hash_d.db").delete();
    new File("dados/livros.hash_c.db").delete();

    ArquivoLivros arqLivros;
    Livro l1 = new Livro(-1, "9788563560278", "Odisseia", 15.99F);
    Livro l2 = new Livro(-1, "9788584290483", "Ensino Híbrido", 39.90F);
    Livro l3 = new Livro(-1, "9786559790005", "Modernidade Líquida", 48.1F);
    Livro l4 = new Livro(-1, "9788582714911", "Memória", 55.58F);
    Livro l5 = new Livro(-1, "9786587150062", "Com Amor", 48.9F);
    Livro l6 = new Livro(-1, "9788584290483", "arthur", 39.90F);
    int id1, id2, id3, id4, id5;

    try {
      arqLivros = new ArquivoLivros("dados/livros.db");

      id1 = arqLivros.create(l1);
      l1.setID(id1);
      System.out.println("Livro de ID " + id1 + " incluído");
      id2 = arqLivros.create(l2);
      l2.setID(id2);
      System.out.println("Livro de ID " + id2 + " incluído");

      id3 = arqLivros.create(l3);
      l3.setID(id3);

      id4 = arqLivros.create(l4);
      l4.setID(id4);

      id5 = arqLivros.create(l5);
      l5.setID(id5);

      System.out.println(arqLivros.read(3));
      System.out.println(arqLivros.read(1));
      System.out.println(arqLivros.read(2));

      System.out.println("Exclusáo do livro 2");
      if (arqLivros.delete(id2))
      System.out.println("Livro de ID " + id2 + " excluído");

      System.out.println(arqLivros.read(2));
      System.out.println(arqLivros.read(3));
      l5.setID(3);
      arqLivros.update(l5);
      System.out.println(arqLivros.read(3));
      arqLivros.create(l6);
      arqLivros.delete(3);
      //2B de tamanho

      
      // else
      // System.out.println("Livro não encontrado]");

      // l4.setTitulo("A Minha Memória");
      // if (arqLivros.update(l4))
      // System.out.println("Livro de ID " + l4.getID() + " alterado");
      // else
      // System.out.println("Livro de ID " + l4.getID() + " não encontrado");

      /*
       * arqLivros.reorganizar();
       * 
       * System.out.println(arqLivros.read(1));
       * System.out.println(arqLivros.read(2));
       * System.out.println(arqLivros.read(3));
       * System.out.println(arqLivros.read(4));
       * System.out.println(arqLivros.read(5));
       * 
       * new File("dados/autor.db").delete();
       * 
       * ArquivoAutores arqAutores = new ArquivoAutores("dados/autor.db");
       * Autor a1 = new Autor("Homero");
       * Autor a2 = new Autor("Lilian Bacich");
       * 
       * Autor a0;
       * arqAutores.create(a1);
       * arqAutores.create(a2);
       * a0 = arqAutores.read(1);
       * System.out.println(a0);
       * 
       * new File("dados/rel_livro_autor.db").delete();
       * 
       * ArquivoRelLivroAutor arqRLA = new
       * ArquivoRelLivroAutor("dados/rel_livro_autor.db");
       * RelLivroAutor rla1 = new RelLivroAutor(1, 1);
       * id1 = arqRLA.create(rla1);
       * rla1.setID(id1);
       */

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
