package controle;

import java.io.IOException;
import java.net.SocketTimeoutException;
import javax.swing.JOptionPane;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class buscaCEP {
    
        public static boolean existe(String CEP) throws IOException {

        try {
            Document doc = Jsoup.connect("http://www.qualocep.com/busca-cep/" + CEP)
                    .timeout(120000)
                    .get();
            Elements urlPesquisa = doc.select("span[itemprop=postalCode]");
            for (Element urlEndereco : urlPesquisa) {
                if(urlEndereco.text().equals(CEP))
                return true;
            }
        } catch (SocketTimeoutException | HttpStatusException e) {
        }
        return false;
    }

    public static String getEndereco(String CEP) throws IOException {

        try {
            Document doc = Jsoup.connect("http://www.qualocep.com/busca-cep/" + CEP)
                    .timeout(120000)
                    .get();
            Elements urlPesquisa = doc.select("span[itemprop=streetAddress]");
            for (Element urlEndereco : urlPesquisa) {
                return urlEndereco.text();
            }
        } catch (SocketTimeoutException | HttpStatusException e) {
        }
        return CEP;
    }

    public static String getBairro(String CEP) throws IOException {
        try {
            Document doc = Jsoup.connect("http://www.qualocep.com/busca-cep/" + CEP)
                    .timeout(120000)
                    .get();
            Elements urlPesquisa = doc.select("td:gt(1)");
            for (Element urlBairro : urlPesquisa) {
                return urlBairro.text();
            }
        } catch (SocketTimeoutException | HttpStatusException e) {
        }
        return CEP;
    }

    public static String getCidade(String CEP) throws IOException {
        try {
            Document doc = Jsoup.connect("http://www.qualocep.com/busca-cep/" + CEP)
                    .timeout(120000)
                    .get();
            Elements urlPesquisa = doc.select("span[itemprop=addressLocality]");
            for (Element urlCidade : urlPesquisa) {
                return urlCidade.text();
            }
        } catch (SocketTimeoutException | HttpStatusException e) {
        }
        return CEP;
    }

    public static String getUF(String CEP) throws IOException {
        try {
            Document doc = Jsoup.connect("http://www.qualocep.com/busca-cep/" + CEP)
                    .timeout(120000)
                    .get();
            Elements urlPesquisa = doc.select("span[itemprop=addressRegion]");
            for (Element urlUF : urlPesquisa) {
                return urlUF.text();
            }
        } catch (SocketTimeoutException | HttpStatusException e) {
        }
        return CEP;
    }
    public static String getCEP(String endereco, String cidade, String uf) throws IOException {
        try {
            Document doc = Jsoup.connect("http://www.qualocep.com/busca-endereco/"+endereco+"/"+cidade+"/"+uf)
                    .timeout(120000)
                    .get();
            Elements urlPesquisa = doc.select("tr:gt(0).[1]");
            for (Element urlUF : urlPesquisa) {
                return urlUF.text();
            }
        } catch (SocketTimeoutException | HttpStatusException e) {
        }
        return "-1";
    }
    
            public static boolean enviaSms(String sms, String numero) throws IOException {
                System.out.println("http://www.fsist.com.br/sms.aspx?tel="+numero+"&msg="+sms);
        try {
            Document doc = Jsoup.connect("http://www.fsist.com.br/sms.aspx?tel="+numero+"&msg="+sms)
                    .timeout(120000)
                    .get();
                return true;
        } catch (SocketTimeoutException | HttpStatusException e) {
        }
        return false;
    }
    
    
}
