import aeds3.Arquivo;

public class ArquivoLivros extends Arquivo<Livro> {

  public ArquivoLivros(String na) throws Exception {
    super(na, Livro.class.getConstructor());
  }

  public Livro readISBN(String isbn) throws Exception {
    Livro obj = new Livro();
    int tam;
    byte lapide;
    arquivo.seek(TAM_CABECALHO);
    while (arquivo.getFilePointer() < arquivo.length()) {
      lapide = arquivo.readByte();
      tam = arquivo.readShort();
      byte[] ba = new byte[tam];
      arquivo.read(ba);

      if (lapide == ' ') {
        obj.fromByteArray(ba);
        if (obj.getIsbn().compareTo(isbn) == 0)
          return obj;
      }
    }
    return null;
  }

}
