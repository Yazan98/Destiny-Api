package com.yazan98.destiny.server.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Created By : Yazan Tarifi
 * Date : 1/1/2020
 * Time : 1:23 PM
 */

@Configuration
public class FirebaseConfiguration {

    @Bean
    public FirebaseApp getFirebaseConfiguaration() throws IOException {
        ByteArrayInputStream serviceAccount = new ByteArrayInputStream(getFirebaseDetails().getBytes(StandardCharsets.UTF_8));
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://destiny-51653.firebaseio.com")
                .build();
        return FirebaseApp.initializeApp(options);
    }

    private String getFirebaseDetails() {
        return "{\n" +
                "  \"type\": \"service_account\",\n" +
                "  \"project_id\": \"destiny-51653\",\n" +
                "  \"private_key_id\": \"6ba7a4084286187792e9143e0eb7089be56d5223\",\n" +
                "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDRUiLjguQ0Wv2g\\nqWhNBldGizz+VZMwWDz4CLGZGLXUs+fMxkIWx3wzueCY2TxXulE3C8CxNkYJ8acq\\nlrCPtDIDabDRN0OTe8vBwob9y1HlOdUb7ZYQ5lTRcBK1RdB9SOjkBO5/uNVaVtlD\\nGB5r9+vK6N4SLQf47Y7yePO+lo/2iH2Y8m8Ltz8tawFycGXkfkdg3oLE9inQLSZl\\nOTEinyoQLniXyvCdFSHAcV+tho45Cl1BlvCOk9uB5gO4u1GOIBWORLackkA2tY7M\\nE7OllFFXT2Y5/aIRAHfPySDeZczJsdDURMeTiRm2bRu3sBNiXuQxNLGdC+VBssy0\\nc/Xu7ODFAgMBAAECggEAQWkA1QagiEnMyulVWgh6umUlZLbaHXfdaYbR9Kz3mSW0\\n8FUd7t9cjQ9vQ2RTCnkDCwgFqXrzzQSyP8lCGE3veQiMg/xYhhxf0kcXBvUDvPVj\\nBmyqgdJwO9hhSDsuSRBBEowF+WyJY0cTcnd1fjjFeq1lQ9nFjYCytEueo3aKOzff\\nh2Z/i2pmTM2eawqLr80LDsOaKNyjEv373Vo3w0bgTIGNJAl1LdGI3ABL/WAE8+Lv\\neSzwVT7D7sb4zGyjwA8kozKAX6LO7hf+IYacjab0H427cUDUBUfoYHhdmhKgNGxm\\noW9ZU4ltxPopIele6vbXB6HSBANzS/OwQdK3U3wqywKBgQD8w9BG3Bh4upB5Hakh\\nfykt4w7nc73YZpetMoKfY1bUSTdhjiL2SEJVK6trkGXuMTVnJjg2ek9Z/T2/gZ8F\\ngU1IzcKDCC6mxz4DJFGwOQM45kX8OBkHMIwW2h6Ow0JbLyEzD3PaSdwZYjASlTtr\\nEqOKekSnWzN4ulWlnJ5IIZrc8wKBgQDT//pWg2KtYgxJiKyB5jUrWCOo4wUUfzCf\\nbRN4W/Delpjd+p33+lMmagUvvPMx5dhOk5Fb9+QDi7vQ5R8utZqYkksRaIkkqKaM\\n1IGEXiD7qNVs5ShcBhzX6GaDDNdtCmD6GR5RvETmssdzP7AHoNsIVOsbWnvi9Td8\\nlrtbj1zZZwKBgQDHb8Fgh70PVTU1Oz/93BWjzSovWVWL77bxw47pMDqMmZCG+t1/\\nMZiVFzXUU0T54f3e+3sTEQKXYIdeGWpdr55JOYCmXshgc4jsdbW2s+Vk+dxym9iz\\noYyHY2cFAe/TfqZVYXXp4Kk3pg+EOhd97mD3nG2bFwzPz0ZQu/jvtQQ6HQKBgHm8\\nVwNQxNwtHkMngW/CQqvWG/wCCMvBUalqmDCYExOuRK/LFuTr0M2ROdM03C29/1z3\\nrhOyoDNNDReiSiqnS9PqxcKEVaRAWAssiAb7ilMYmx3B5VAajnuIzzzXpejOeeuD\\nev6SbrpO1OsgGjP3MW9yW+NELTmheDBJ2eJ0y2tnAoGBAKb4DkD1WNC/DAkFlWMK\\n7fB8EXf1zI24+J5b+tRnv0jn+Lctyj30CgoWZW3ql5SEJ9ux37DjYoS+aGBhx9Uu\\nKqNPbbEpMUvNV/WNKYbXvmxGcU7Uc4U9s73/BS3aGodPPZ6qu1+exV224FIg9o26\\nrsZ+TOzyCnzORhGN61y7mYni\\n-----END PRIVATE KEY-----\\n\",\n" +
                "  \"client_email\": \"firebase-adminsdk-vitsc@destiny-51653.iam.gserviceaccount.com\",\n" +
                "  \"client_id\": \"113364051013766534981\",\n" +
                "  \"auth_uri\": \"https://accounts.google.com/o/oauth2/auth\",\n" +
                "  \"token_uri\": \"https://oauth2.googleapis.com/token\",\n" +
                "  \"auth_provider_x509_cert_url\": \"https://www.googleapis.com/oauth2/v1/certs\",\n" +
                "  \"client_x509_cert_url\": \"https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-vitsc%40destiny-51653.iam.gserviceaccount.com\"\n" +
                "}\n";
    }

}
