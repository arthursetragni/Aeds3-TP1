import aeds3.Arquivo;

public class ArquivoAutores extends Arquivo<Autor> {

  public ArquivoAutores(String na) throws Exception {
    super(na, Autor.class.getConstructor());
  }

}
