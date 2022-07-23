package com.sample.app.enumerator;

import com.sample.app.service.IExtractor;
import com.sample.app.service.impl.ExtractorDeployedAPI;
import com.sample.app.service.impl.ExtractorNASA;
//import com.sample.app.service.impl.ExtractorIMDb;

public enum UrlExtractorEnum {
    //API_IMDB("https://alura-filmes.herokuapp.com/conteudos", new ExtractorIMDb()),
    API_CUSTOM("https://springboot-imagens-api-alura.herokuapp.com/imagens", new ExtractorDeployedAPI()),
    API_NASA("https://api.mocki.io/v2/549a5d8b/NASA-APOD", new ExtractorNASA());

    private String url;
    private IExtractor extractor;

    UrlExtractorEnum(String url, IExtractor extractor) {
        this.url = url;
        this.extractor = extractor;
    }

    public String getUrl() {
        return this.url;
    }

    public IExtractor getExtractor() {
        return this.extractor;
    }
}
