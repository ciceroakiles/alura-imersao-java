
# alura-imersao

Objetivo geral: consumir APIs de imagens e gerar figurinhas customizadas com elas. Os códigos de exemplo abaixo podem ou não estar presentes na versão atual.

## Desafios da parte 1
https://www.alura.com.br/imersao-java/aulas/aula01-consumindo-api-com-java

* Usar uma alternativa ao IMDb para pegar imagens de filmes (FEITO)

```
// String url1 = "https://api.mocki.io/v2/" + API_KEY + "/MostPopularMovies";
String url2 = "https://alura-filmes.herokuapp.com/conteudos";
```

Solução adotada: trocar a URL da API de filmes e modificar o tratamento dos dados.

* Editar a saída da nota (FEITO)

```
public static String starChar() {
	String os = System.getProperty("os.name");
	if (os.contains("Windows")) return "*";
	if (os.contains("Linux")) return "+";
	return ""; // (ou seja, nada de estrelas para usuarios de Mac)
}
```

Solução adotada: dependendo do sistema operacional, certos caracteres como emojis não são impressos corretamente; logo, foi feita uma classe que detecta o mesmo e altera o caractere utilizado para exibir a nota do filme com estrelas.

* Extrair chave da API para um arquivo de properties (FEITO)

```
String AKI_KEY = PropertyManager.getApiKey("dev.properties");
```

Solução adotada: após deixar a chave no arquivo de properties, incluir o mesmo no arquivo ```.gitignore```.

* Importar uma biblioteca para fazer o parse do JSON (FEITO)

```
<dependency>
	<groupId>com.fasterxml.jackson.core</groupId>
	<artifactId>jackson-databind</artifactId>
	<version>{{version}}</version>
</dependency>
```

Solução adotada: usar o Maven no projeto e incluir a dependência acima no arquivo ```pom.xml```.
 
* Receber uma avaliação do usuário (FEITO)

```
Scanner sc = new Scanner(System.in);
Double novaNota = Double.parseDouble(sc.next());
```

Solução adotada: utilizar a classe Scanner para entrada de dados.

* Imprimir um poster: talvez, futuramente, retornar uma matriz gigante com uma "ASCII Art" ou um monte de caracteres em braille que lembram a própria imagem.


## Desafios da parte 2
https://www.alura.com.br/imersao-java/aulas/aula02-stickers-com-whatsapp

* Criar um diretório automaticamente para o arquivo de saída (FEITO)

```
File arquivo = new File("nomeArquivo");
if (!arquivo.exists()) {
	arquivo.mkdirs(); // (cria a pasta)
}
```

Solução adotada: criar uma classe (contendo o trecho acima) cuja única responsabilidade é lidar com arquivos.

* Centralizar texto em relação à imagem (FEITO)

```
int textX = (int) (width - legWidth)/2;
```

Solução adotada: deixar a posição horizontal da legenda como sendo primariamente relativa às larguras da imagem e da legenda.

* Tratar a URL da imagem para obter uma maior (FEITO)

```
String urlImagemMaior = urlImagem.replace(
urlImagem.substring(
	urlImagem.indexOf("._"), urlImagem.lastIndexOf(".")), ""
);
```

Solução adotada: realizar o tratamento do endereço original (no caso acima, removendo uma ```substring```).

* Personalizar texto da figurinha em relação à nota (FEITO)

```
private String textoLegenda(double nota) {
	return (nota >= 9) ? "TOPZERA!" :
		(nota >= 7.25) ? "MUITO BOM!" :
		(nota >= 5.5) ? "MAIS OU MENOS!" :
		(nota >= 2.75) ? "DORMI NO MEIO!" :
		"NEM VI!";
}
```

Solução adotada: escrever um método que retorna uma legenda, a qual varia de acordo com o valor da nota.

* Consumir APIs de imagens com estruturas JSON diferentes (FEITO)

Solução adotada: usar cada um dos extratores em uma classe diferente. Como visto a seguir.


## Desafios da parte 3
https://www.alura.com.br/imersao-java/aulas/aula03-orientacao-a-objetos

* Mudar a classe Conteudo para record (realizável apenas usando Java 14 ou posterior)

* Criar uma exceção customizada (FEITO)

* Usar um enum com URL e extrator de conteúdo (FEITO)

* Usar alguma API de imagens completamente diferente


Mais explicações em breve.
Continua...
