import aeds3.Arquivo;

public class ArquivoRelLivroAutor extends Arquivo<RelLivroAutor> {

  public ArquivoRelLivroAutor(String na) throws Exception {
    super(na, RelLivroAutor.class.getConstructor());
  }

}
