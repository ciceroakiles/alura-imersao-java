# alura-imersao-java

Objetivo geral: consumir APIs de imagens e gerar figurinhas customizadas com elas. Os códigos de exemplo nos docs podem ou não estar presentes na versão atual.

# Desafios da parte 1
https://www.alura.com.br/imersao-java/aulas/aula01-consumindo-api-com-java

<details>
<summary>Usar uma alternativa ao IMDb para pegar imagens de filmes</summary>
<br>

```
// String url1 = "https://api.mocki.io/v2/" + API_KEY + "/MostPopularMovies";
String url2 = "https://alura-filmes.herokuapp.com/conteudos";
```

Solução adotada: trocar a URL da API de filmes e modificar o tratamento dos dados.

---
</details>

<details>
<summary>Editar a saída da nota</summary>
<br>

```
String os = System.getProperty("os.name");
if (os.contains("Windows")) return "*";
if (os.contains("Linux")) return "+";
return ""; // (ou seja, nada de estrelas para usuarios de Mac)
```

Solução adotada: dependendo do sistema operacional, certos caracteres como emojis não são impressos corretamente; logo, foi feita uma classe que detecta o mesmo e altera o caractere utilizado para exibir a nota do filme com estrelas.

---
</details>

<details>
<summary>Extrair chave da API para um arquivo de properties</summary>
<br>

```
String API_KEY = PropertyManager.getApiKey("dev.properties");
```

Solução adotada: após deixar a chave no arquivo de properties, incluir o mesmo no arquivo ```.gitignore```.

---
</details>

<details>
<summary>Importar uma biblioteca para fazer o parse do JSON</summary>
<br>

```
<dependency>
	<groupId>com.fasterxml.jackson.core</groupId>
	<artifactId>jackson-databind</artifactId>
	<version>{{version}}</version>
</dependency>
```

Solução adotada: usar o Maven no projeto e incluir a dependência acima no arquivo ```pom.xml```.

---
</details>

<details>
<summary>Receber uma avaliação do usuário</summary>
<br>

```
Scanner sc = new Scanner(System.in);
Double novaNota = Double.parseDouble(sc.next());
```

Solução adotada: utilizar a classe Scanner para entrada de dados.

---
</details>

<details>
<summary>Imprimir um poster</summary>
<br>

Talvez, futuramente, retornar uma matriz gigante com uma "ASCII Art" ou um monte de caracteres em braille que lembram a própria imagem.

---
</details>


# Desafios da parte 2
https://www.alura.com.br/imersao-java/aulas/aula02-stickers-com-whatsapp

<details>
<summary>Criar um diretório automaticamente para o arquivo de saída</summary>
<br>

```
File arquivo = new File("nomeArquivo");
if (!arquivo.exists()) {
	arquivo.mkdirs(); // (cria a pasta)
}
```

Solução adotada: criar uma classe (contendo o trecho acima) cuja única responsabilidade é lidar com arquivos.

---
</details>

<details>
<summary>Centralizar texto em relação à imagem</summary>
<br>

```
int textX = (int) (width - legWidth)/2;
```

Solução adotada: deixar a posição horizontal da legenda como sendo primariamente relativa às larguras da imagem e da legenda.

---
</details>

<details>
<summary>Tratar a URL da imagem para obter uma maior</summary>
<br>

```
String urlImagemMaior = urlImagem.replace(
urlImagem.substring(
	urlImagem.indexOf("._"), urlImagem.lastIndexOf(".")), ""
);
```

Solução adotada: realizar o tratamento do endereço original (no caso acima, removendo uma ```substring```).

---
</details>

<details>
<summary>Personalizar texto da figurinha em relação à nota</summary>
<br>

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

---
</details>

<details>
<summary>Consumir APIs de imagens com estruturas JSON diferentes</summary>
<br>

Solução adotada: usar cada um dos extratores em uma classe diferente, como proposto na parte 3.

---
</details>


# Desafios da parte 3
https://www.alura.com.br/imersao-java/aulas/aula03-orientacao-a-objetos

<details>
<summary>Mudar a classe Conteudo para "record"</summary>
<br>

Realizável apenas usando Java 14 ou posterior.

---
</details>

<details>
<summary>Utilizar uma exceção customizada</summary>
<br>

```
public class CustomMsgException extends Exception {

	public CustomMsgException(String msg, Throwable err) {
		super(msg, err);
	}
}
```

Solução adotada: criar uma subclasse específica, responsável por lançar a exceção.

---
</details>

<details>
<summary>Utilizar um enum com URL e extrator de conteúdo</summary>
<br>

```
public enum UrlExtractorEnum {
	API_IMDB("https://endereco1.etc.com/recurso/", new ExtractorIMDb()),
	API_NASA("https://endereco2.etc.com/recurso/", new ExtractorNASA());

	[...]
}
```

Solução adotada: dessa forma, é possível associar cada ```String``` com cada ```IExtractor```.

---
</details>

<details>
<summary>Usar alguma API de imagens completamente diferente</summary>
<br>

Solução adotada: fazer a própria API, como proposto nas partes 4 e 5.

---
</details>

<br>
Continua no segundo repositório:

https://github.com/ciceroakiles/springboot-imagens-api-alura
