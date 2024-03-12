import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.text.NumberFormat;

import aeds3.Registro;

public class Livro implements Registro {

  private int ID;
  private String isbn;
  private String titulo;
  private float preco;

  public Livro() {
    this(-1, "", "", 0F);
  }

  public Livro(String i, String t, float p) {
    this(-1, i, t, p);
  }

  public Livro(int id, String i, String t, float p) {
    this.ID = id;
    this.isbn = i;
    this.titulo = t;
    this.preco = p;
  }

  public int getID() {
    return ID;
  }

  public void setID(int iD) {
    ID = iD;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public float getPreco() {
    return preco;
  }

  public void setPreco(float preco) {
    this.preco = preco;
  }

  public byte[] toByteArray() throws Exception {
    ByteArrayOutputStream ba_out = new ByteArrayOutputStream();
    DataOutputStream dos = new DataOutputStream(ba_out);
    dos.writeInt(this.ID);
    dos.write(this.isbn.getBytes());
    dos.writeUTF(this.titulo);
    dos.writeFloat(this.preco);
    return ba_out.toByteArray();
  }

  public void fromByteArray(byte[] ba) throws Exception {
    byte[] straux = new byte[13];
    ByteArrayInputStream ba_in = new ByteArrayInputStream(ba);
    DataInputStream dis = new DataInputStream(ba_in);
    this.ID = dis.readInt();
    dis.read(straux);
    this.isbn = new String(straux);
    this.titulo = dis.readUTF();
    this.preco = dis.readFloat();
  }

  public String toString() {
    return "ID: " + this.ID +
        "\nISBN: " + this.isbn +
        "\nTítulo: " + this.titulo +
        "\nPreço: " + NumberFormat.getCurrencyInstance().format(this.preco);
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
