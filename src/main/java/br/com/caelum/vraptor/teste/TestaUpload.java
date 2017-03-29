package br.com.caelum.vraptor.teste;

import java.io.File;
import java.io.IOException;

import br.com.caelum.vraptor.component.Imagens;
import br.com.caelum.vraptor.modelo.Produto;
import br.com.caelum.vraptor.observer.upload.UploadedFile;

public class TestaUpload {
private static UploadedFile imagem;

public static void main(String[] args) throws IOException {
	Produto produto = new Produto();
	produto.setId(1L);
	produto.setNome("Lâmpada");
	produto.setDescricao("Lampada 110 - 20W");
	produto.setPreco(20.10);
	Imagens imagens = new Imagens();
	imagens.init();
	File arquivo = new File("C:\\Users\\tiago\\Downloads\\a10\\madeira.jpg");
	System.out.println(arquivo.getName());

}
}
