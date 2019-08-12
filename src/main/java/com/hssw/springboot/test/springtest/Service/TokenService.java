package com.hssw.springboot.test.springtest.Service;

import java.security.spec.KeySpec;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import com.hssw.springboot.test.springtest.Exception.BusinessException;
import com.hssw.springboot.test.springtest.Exception.BusinessExceptions;
import com.hssw.springboot.test.springtest.Service.Key.IKey;
import com.hssw.springboot.test.springtest.Util.Security.CryptoManager;

import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import io.jsonwebtoken.*;

@Service
public class TokenService {

    @Autowired
    private IKey key;

    public TokenService(){

    }


    //返回站点特定密钥
    public String GetSiteSecretKey(String domain){
        
        //链接数据库
        return "nuljdiful";
    }

    //生成站点特定密钥
    private String GenerateSiteSecretKeySHA256(String domain){
        String base_str = domain + Time.now();
        String secretKey = DigestUtils.md5DigestAsHex(base_str.getBytes());
        return secretKey;
    }

    //保存站点特定密钥
    private void SaveSiteSecretKey(String domain,String key){
        //key value 写入
    }

    //生成站点密钥
    public void SiteSecretKeyGenerator(String domain){
        String key = GenerateSiteSecretKeySHA256(domain);
        SaveSiteSecretKey(domain,key);
        
    }

    //生成token
    public String GenerateUserToken(String subject,int ttl){

        //加密算法SHA256
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        SecretKey key = (SecretKey)this.key.GetKey();
        //添加字段
        long nowMillions = System.currentTimeMillis();
        Date now = new Date(nowMillions);

        //
        JwtBuilder builder = Jwts.builder()
        .setIssuer("Hssw")
        .setIssuedAt(now)
        .setSubject(subject)
        .signWith(signatureAlgorithm,key);

        return builder.compact();

    }

    //获取token Secret Key
    private SecretKey GetTokenSecretKey(String secretKey){

        try{
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");

            KeySpec keySpec = new DESKeySpec(secretKey.getBytes());
            SecretKey key = secretKeyFactory.generateSecret(keySpec);
            return key;
        }
        catch(Exception e){
            //
            return null;
        }
    }

    //检查token是否有效
    public String ParseToken(String token){
        SecretKey key = (SecretKey)this.key.GetKey();
        try{
            Claims claims = Jwts.parser()
                            .setSigningKey(key)
                            .parseClaimsJwt(token)
                            .getBody();
                            
            return claims.getSubject();
        }
        catch(Exception e){
            return null;
        }

    }


    
}