package com.xy.cert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.CertPath;
import java.security.cert.CertPathParameters;
import java.security.cert.CertPathValidator;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;

public class CertDev1 {

	public static void main(String[] args) throws CertificateException, NoSuchAlgorithmException, IOException,
			KeyStoreException, CertPathValidatorException, InvalidAlgorithmParameterException {

		System.out.println(Security.getProviders());

		CertificateFactory certFactory = CertificateFactory.getInstance("X.509");

		println(certFactory);

		// instantiate a KeyStore with type JKS
		KeyStore ks = KeyStore.getInstance("pkcs12");
		// load the contents of the KeyStore
		ks.load(new FileInputStream("E:\\code2\\dc\\src\\main\\resources\\oop.p12"), "123456".toCharArray());
		// fetch certificate chain stored with alias "sean"
		Certificate[] certArray = ks.getCertificateChain("xiuye");

		// convert chain to a List
		List certList = Arrays.asList(certArray);
		// instantiate a CertificateFactory for X.509
		CertificateFactory cf = CertificateFactory.getInstance("X.509");
		// extract the certification path from
		// the List of Certificates
		CertPath cp = cf.generateCertPath(certList);

//		CertPath cp = certFactory.generateCertPath(new FileInputStream("E:\\code\\cert\\wuming3.keystore"), "JKS");

		println(cp);

		List<? extends Certificate> certs = cp.getCertificates();
		for (Certificate cert : certs) {
			System.out.println("certificate:\n\t"+cert);
			System.out.println("oids:\n\t"+((X509Certificate)cert).getCriticalExtensionOIDs());
			
		}

		
		// create CertPathValidator that implements the "PKIX" algorithm
		CertPathValidator cpv = null;
		cpv = CertPathValidator.getInstance("PKIX");
		// validate certification path ("cp") with specified parameters ("params")
		CertPathValidatorResult cpvResult = cpv.validate(cp, null);

//		cpvResult
		
	}

	private static <T> void println(T t) {
		System.out.println(t);
	}

}
