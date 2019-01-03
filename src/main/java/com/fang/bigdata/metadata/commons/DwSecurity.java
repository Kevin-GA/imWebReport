package com.fang.bigdata.metadata.commons;

import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;



/**
  * Created by user on 2017/11/20.
  */
public class DwSecurity {
 public static String  publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCP1rXxYHMZsqk5VEdpt1zFGEAye3GgQfh6JcRE6HHSTgY01VftXsl6EMrXZPNfrv2KiP3HNWTj9nFZqLK7PhtWG7ZU7NP2X9axOZn7+4+Jz47quQuesO5OHWb7avDbdN1R19jF4VmwMYjx56TASPwCvk6oHO5HaI7nSqbf/aNOfQIDAQAB";
  public static  String privateKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAI/WtfFgcxmyqTlUR2m3XMUYQDJ7caBB+HolxETocdJOBjTVV+1eyXoQytdk81+u/YqI/cc1ZOP2cVmosrs+G1YbtlTs0/Zf1rE5mfv7j4nPjuq5C56w7k4dZvtq8Nt03VHX2MXhWbAxiPHnpMBI/AK+Tqgc7kdojudKpt/9o059AgMBAAECgYANPkWOLcUrLonqH1pb32gJNYxjmX4CtVA9XtDNT2F7bXeg0avAzSNbu8QRRNgrjR8G7EoBV2csnfoduSyLlNJLXdeIlAenLVEgUR5HE7fZvpiVamINZedpBfvm3d+miCVOWWFJK3piKRZ20jyZGRZ4JvYqF/EiYQr/pux73Noz+QJBANDS08rqk2ae8nL2z1xW7t1kLL446ht16hCgtY8JZC5Rbl5iF7cyEFxMvokbc2MBnkbEaHoXt45uJKLQi94b8dsCQQCwVYdCp6jZzzj0Ah2wJvqOSBm/yc4gVutqU9sKCr9S8Ri7lEVBKzQXu6cpyF+/ulxuG6QY0Nz5uDFOe1VW2YyHAkBc7gW8nqmcGI4SpU1gbXt9YLAcsx1TvSS945cIoYhIqIpyTDr7lrb7LFf6khHGdJjoK03HT7irFM8O+bnUzSDTAkA91TACEpKmFgEtp1RLwc9YdzX4R8atFm2kslT7t3sRlZOLq1mBmanBrL7YavgQXkQtJCotvYfPVWSM1bi+JLkfAkBwVVdQKgdUINe0X22oVJ0840ZjzEqiuXejUz0mm3O89aTfFiLJAoVGuAD/j9ONTVvxYI7yUmFRFgUT7bp+bi0R";

  public DwSecurity() throws InvalidKeySpecException, NoSuchAlgorithmException {
  }

  public static String rsaEncrypt(String s) throws Exception {
    if (s == null || s.isEmpty()) {
      return "";
    } else {
     return  RSAutil.encryptByPublicKey(s, RSAutil.getPublicKey(DwSecurity.publicKey));
    }
  }

  public static String rsaDecrypt(String s) throws Exception {
    if (s == null || s.isEmpty()) {
     return  "";
    } else {
     return RSAutil.decryptByPrivateKey(s, RSAutil.getPrivateKey(DwSecurity.privateKey));
    }
  }
}
