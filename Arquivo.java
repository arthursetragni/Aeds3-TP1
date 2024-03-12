import java.io.RandomAccessFile;

public class Arquivo {

  RandomAccessFile arq;

  public Arquivo(String nomeArquivo) throws Exception {
    arq = new RandomAccessFile(nomeArquivo, "rw");
    if (arq.length() < 4) {
      arq.seek(0);
      arq.writeInt(0);
    }
  }

  public int create(Livro l) throws Exception {
    int ultimoID;
    arq.seek(0);
    ultimoID = arq.readInt();
    ultimoID++;
    arq.seek(0);
    arq.writeInt(ultimoID);
    l.setID(ultimoID);

    byte[] ba = l.toByteArray();
    arq.seek(arq.length());
    arq.writeByte(' ');
    arq.writeShort(ba.length);
    arq.write(ba);
    return l.getID();
  }

  public Livro read(int id) throws Exception {
    Livro l = new Livro();
    int tam;
    byte lapide;
    arq.seek(4);
    while (arq.getFilePointer() < arq.length()) {
      lapide = arq.readByte();
      tam = arq.readShort();
      byte[] ba = new byte[tam];
      arq.read(ba);

      if (lapide == '*')
        continue;

      l.fromByteArray(ba);
      if (l.getID() == id)
        return l;
    }
    return null;
  }

  // ---------------------
  // A IMPLEMENTAR:
  // - UPDATE
  // - DELETE
  //
  // TRANSFORMAR EM UM CLASSE DE TIPO GENÉRICO T
  // ---------------------

  public void close() throws Exception {
    arq.close();
  }

}
