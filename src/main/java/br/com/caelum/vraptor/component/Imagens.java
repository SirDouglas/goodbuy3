package br.com.caelum.vraptor.component;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;


import br.com.caelum.vraptor.modelo.Produto;
import br.com.caelum.vraptor.observer.upload.UploadedFile;

@Dependent
public class Imagens {

	private File pastaImagens;

	private final Path DEFAULT_FOLDER = Paths.get("/imagens");
	
	

	
	@PostConstruct
public void init() {
	System.out.println("Terra terra " + DEFAULT_FOLDER.toString()); 
String caminhoImagens = DEFAULT_FOLDER.toString(); 
	this.pastaImagens = new File(caminhoImagens);
	this.pastaImagens.mkdir();

}
	


	
	public void salva(UploadedFile imagem,Produto produto)  {
		File destino = new File(this.pastaImagens,produto.getId() + ".imagem");
	try {
	//	IOUtils.copy(imagem.getFile(),new FileOutputStream(destino));
	//  imagem.writeTo(destino);
	  imagem.writeTo(new FileOutputStream(destino));
	  		System.out.println("Terra 2 " + destino.toString());
	  		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		  throw new RuntimeException("Imagem não encontrada " + e);
	} catch (IOException e) {
		// TODO Auto-generated catch block
	  throw new RuntimeException("Erro ao copiar imagem " + e);
	}
		
		
	
		
	}

	private String getFileName(Produto produto) {
		// TODO Auto-generated method stub
		return "image" + produto.getId() + ".imagem";
	}






	public File mostra(Produto produto) {
		// TODO Auto-generated method stub
		System.out.println("Terra 3 " + pastaImagens + produto.getId());
		return new File(pastaImagens,produto.getId() +".imagem");
	}
	
	
	
	public File getFile(Produto produto) {
		return DEFAULT_FOLDER.resolve(getFileName(produto)).toFile();
	}
	
	
}
