import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import aeds3.Registro;

public class RelLivroAutor implements Registro {

  private int ID;
  private int IDLivro;
  private int IDAutor;

  public RelLivroAutor() {
    this(-1, -1, -1);
  }

  public RelLivroAutor(int i1, int i2) {
    this(-1, i1, i2);
  }

  public RelLivroAutor(int id, int i1, int i2) {
    this.ID = id;
    this.IDLivro = i1;
    this.IDAutor = i2;
  }

  public int getID() {
    return ID;
  }

  public void setID(int iD) {
    ID = iD;
  }

  public int getIDLivro() {
    return IDLivro;
  }

  public void setIDLivro(int iDLivro) {
    IDLivro = iDLivro;
  }

  public int getIDAutor() {
    return IDAutor;
  }

  public void setIDAutor(int iDAutor) {
    IDAutor = iDAutor;
  }

  public byte[] toByteArray() throws Exception {
    ByteArrayOutputStream ba_out = new ByteArrayOutputStream();
    DataOutputStream dos = new DataOutputStream(ba_out);
    dos.writeInt(this.ID);
    dos.writeInt(this.IDLivro);
    dos.writeInt(this.IDAutor);
    return ba_out.toByteArray();
  }

  public void fromByteArray(byte[] ba) throws Exception {
    ByteArrayInputStream ba_in = new ByteArrayInputStream(ba);
    DataInputStream dis = new DataInputStream(ba_in);
    this.ID = dis.readInt();
    this.IDLivro = dis.readInt();
    this.IDAutor = dis.readInt();
  }

  public String toString() {
    return "ID: " + this.ID +
        "\nIDLivro: " + this.IDLivro +
        "\nIDAutor: " + this.IDAutor;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  @Override
  public int compareTo(Object b) {
    return this.getID() - ((Livro) b).getID();
  }
}
