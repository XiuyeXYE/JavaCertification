package com.xy.cert;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import com.xiuye.util.cls.TypeUtil;
import com.xiuye.util.log.LogUtil;

public class CertDev3 {

	public static void main(String[] args)
			throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {

		KeyStore ks = KeyStore.getInstance("pkcs12");
		ks.load(null, "123456".toCharArray());

		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
		LogUtil.log(kpg);

		kpg.initialize(2048);
		LogUtil.log(kpg);

		KeyPair keyPair = kpg.generateKeyPair();
		// [48, -126, 4, -67, 2, 1, 0, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1,
		// 1, 5, 0, 4, -126, 4, -89, 48, -126, 4, -93, 2, 1, 0, 2, -126, 1, 1, 0, -60,
		// 60, -19, -94, -27, -75, -127, 104, -99, -111, -117, 18, 50, -95, 37, 89, 57,
		// -32, 88, 33, 29, 59, 91, -104, 75, 2, -93, 25, 49, -86, 100, 37, 116, 77,
		// -94, -25, -83, 12, -90, -122, -127, -24, 107, 33, 86, -106, 80, -42, 70, -4,
		// -116, 66, 110, 103, 106, -43, -48, -60, 8, -124, 29, 34, -109, -107, -36,
		// -22, -44, -10, -50, 127, 44, 4, 11, -13, -63, -58, -80, -71, 83, -104, 11, 4,
		// 79, -90, 48, 34, -5, 71, 102, -62, 97, -41, -124, -113, 110, -128, -25, -21,
		// 91, -111, 82, -7, -24, 28, -94, -74, -91, 5, 91, -111, -68, -125, -80, -23,
		// 86, 70, -59, 96, 88, -29, 14, 124, -25, 37, 72, -109, -52, 8, 19, -106, -57,
		// -94, -6, 107, -37, 23, -58, -36, 121, 22, 71, -97, -57, -53, 76, -8, -106,
		// -6, -2, 92, 49, -111, -87, -3, -21, -64, 94, 37, -74, -46, 66, -17, 95, -55,
		// 99, -107, 57, 36, -66, -66, -3, -67, 32, 67, 120, -44, 21, 33, 97, 58, 125,
		// -94, 82, 12, -104, -117, -67, 27, 10, -75, 114, -116, 57, 33, -56, 48, -2,
		// -74, 58, 8, 78, 89, -99, -10, -25, 58, 46, 101, 83, -39, -95, -106, -3, -46,
		// 102, -99, -125, 55, 91, 79, 87, 118, 99, -125, 28, 87, 65, -30, -3, -53, -61,
		// 28, 74, -63, 88, 34, 74, 11, -4, -101, -96, 121, -2, -40, 81, 69, 85, -49,
		// 110, 1, 62, 125, 5, -72, 110, 7, 2, 3, 1, 0, 1, 2, -126, 1, 0, 58, 97, 73,
		// -19, 33, 91, -117, 33, 61, 103, 52, 49, 120, -64, 122, 36, -2, 83, -32, -60,
		// 17, 55, 60, 123, -91, 45, 38, -86, 115, 29, 22, -24, 17, -98, -101, 45, 67,
		// 77, 53, 41, 100, -14, 105, 20, -92, -10, -39, 27, -74, 72, -95, -51, -115,
		// -100, -44, -86, -63, -115, -32, 94, -75, 112, 56, -23, -25, -84, 49, 41, 47,
		// -85, -93, -61, -100, 110, -85, 34, 90, 38, -8, 88, -114, 70, 125, 15, -102,
		// -40, 125, 90, -13, -106, 54, -105, 112, 71, 95, 127, -105, -1, 107, -31, 99,
		// 7, 23, -25, -108, -4, -77, 65, 81, -55, -100, -124, -83, 23, -19, -29, -26,
		// 10, 80, -57, 83, -29, 18, -67, 3, -57, 124, 118, 16, -1, -18, -98, 53, -92,
		// 80, 45, 45, 45, 33, 1, -25, -19, 68, 31, -114, 91, -54, 120, -65, 93, -105,
		// -8, 28, 77, -45, 82, 11, 35, 83, 116, -117, -16, 8, -95, 73, -68, -95, 94,
		// 106, -91, 2, 8, 14, 27, 72, 106, 50, -105, -80, -102, -103, 24, 34, 23, 57,
		// 47, -21, 67, 34, -46, 19, 122, -83, 93, -1, -26, -101, -47, -88, 5, 95, 72,
		// -57, -52, -127, 99, 28, -86, -124, -26, -20, 12, 32, -93, 13, -4, -60, -58,
		// 5, 46, 5, -54, -100, 108, -23, 117, 90, 18, -120, -38, 65, 107, -109, -46,
		// -115, -89, 121, -54, -75, -62, -119, 117, 12, 48, -33, 16, -45, -22, -94, 60,
		// -96, -120, 76, 61, -106, 25, 2, -127, -127, 0, -17, 83, -33, 1, 1, -47, -63,
		// 101, -48, 114, 10, -112, 86, 115, 103, 84, 0, 110, 39, -64, 18, 101, 90, 105,
		// 99, -57, -48, -90, 103, -98, 13, 11, 25, -15, -122, 30, -65, 119, -28, -128,
		// -82, -85, -103, -10, -104, -22, -93, 83, -21, -63, 125, 98, 59, 39, 17, -38,
		// 19, 99, 106, -78, -109, 69, -11, 82, -99, -20, -78, 86, -112, -56, 116, -66,
		// -91, 68, -114, 4, -7, -113, 83, -20, -96, 102, 14, -5, -48, -81, 14, -80, 93,
		// 26, -124, 1, 110, 81, 116, -27, -91, 20, -2, 4, 60, -83, 77, 44, -77, -104,
		// 124, -97, 126, -68, -28, 42, 101, -29, -39, -14, -77, -83, 121, 115, -69, 14,
		// -122, -107, -96, -27, 116, -125, 2, -127, -127, 0, -47, -24, -102, -93, 38,
		// 63, -74, -37, -121, 57, -103, 23, 72, 10, 104, -124, 101, -119, 65, 71, -54,
		// -97, 65, -24, -15, -113, -58, -16, 58, -88, 102, -11, -67, -78, 104, -33,
		// -85, 82, -6, -74, 26, -126, 57, -22, 95, 85, -77, -65, -24, -92, -33, -89, 6,
		// 122, -41, 95, -61, 100, -107, 111, -23, 9, 17, -56, -100, 13, 76, 25, 110,
		// -111, -107, -33, -58, 58, -73, -5, 93, -40, 12, 4, 68, -113, -105, -34, -25,
		// -6, -112, -33, -35, 62, 32, 115, -57, 86, -72, 20, 18, -100, -71, -77, -57,
		// -74, -114, -63, 20, 124, 98, -67, 28, -33, 25, -67, 43, -43, 101, -92, -92,
		// -44, -8, 21, 74, -16, -81, -84, 22, 108, -47, 45, 2, -127, -128, 5, 44, -78,
		// 16, -86, -126, 103, -123, 21, 9, -78, 50, -58, -69, -66, 11, 49, -21, 47,
		// -50, -42, 86, -4, -86, 116, -82, -40, 83, 16, -64, 121, 21, -71, 92, -32,
		// -126, 127, -81, 78, -16, 125, 86, 86, -128, -33, 115, -117, 78, -128, 53,
		// 113, -55, -110, -17, -40, 81, -9, -61, 89, -122, 60, -22, -15, 79, -12, -4,
		// 46, 42, -14, -4, 114, -111, -64, -81, 7, -57, 17, -62, 72, -107, 64, 46,
		// -108, -70, 91, 27, -67, -36, -112, 86, -57, 109, -28, 125, -68, 98, 78, -68,
		// 114, 117, -110, -2, 72, 65, -28, 44, 50, -35, -101, -10, -25, -108, 7, 25,
		// -13, 23, 109, 77, 29, -24, 35, -82, 63, -72, -78, 126, -29, -109, 2, -127,
		// -128, 72, -118, -29, -114, 72, -76, -78, 68, 49, -6, -124, -34, -41, -27,
		// -56, -13, 32, -120, 11, -56, 124, -51, 7, 33, 51, 2, 102, 85, 53, 96, 103,
		// -100, -69, -65, 65, -95, 50, -5, 77, 107, -53, -61, 127, -78, 112, -38, 20,
		// 113, -39, 59, -55, -109, 86, -104, -13, 127, -61, -18, 41, -6, -16, 5, 83,
		// 97, 10, 21, 74, 92, 107, -86, -30, -87, -32, 63, 0, -64, 93, 81, 65, -19,
		// -29, -89, -32, 107, -121, -82, 63, -115, 46, 79, -65, 53, 100, 9, -93, 58,
		// 68, -88, 103, 65, 43, 94, -6, -4, -35, 80, -109, 107, 25, -28, 60, 103, -11,
		// 19, 29, -70, -123, -64, -104, 47, -5, -93, 44, -125, 3, -120, -3, -51, 2,
		// -127, -127, 0, -38, -59, 54, 23, -35, 114, -35, 80, 117, -59, -82, 32, 18,
		// 103, 99, -37, -46, -54, 15, -93, 77, -58, -88, -11, -124, 55, -116, -60, 18,
		// 84, 43, -80, 7, 77, 124, -68, -102, -45, 41, 18, -38, -38, -52, 27, -100, 82,
		// -89, 84, 45, 8, 23, 126, -89, 80, 72, -94, -113, -38, 118, 105, -4, -52, -83,
		// -119, 120, 90, 86, -99, -92, 80, -128, -57, -8, -93, -30, -67, 111, -98, 67,
		// 120, 109, -60, -124, 4, 25, 86, 103, -31, 83, 107, 78, -45, -126, -76, -48,
		// -125, 74, -35, 32, -73, 67, 124, -113, -35, 89, -103, -69, -116, 64, -48, 56,
		// -52, 35, -115, 69, -14, 112, 59, 120, 49, 46, 83, -73, 10, 85, -124, -38,
		// -106]
		// [48, -126, 4, -67, 2, 1, 0, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1,
		// 1, 5, 0, 4, -126, 4, -89, 48, -126, 4, -93, 2, 1, 0, 2, -126, 1, 1, 0, -88,
		// 84, -110, 1, -48, 115, 45, -81, -72, 119, 112, 101, -30, 109, 105, 41, -82,
		// -79, -47, 14, -25, -90, -117, 93, -33, -82, -64, 28, 72, 67, -60, 15, -39,
		// -51, -97, 78, -124, 69, 96, -88, -7, 126, 114, -68, 59, 55, -3, 91, 46, 31,
		// -38, -47, -118, 92, 14, -40, -72, -51, -94, 69, -2, 85, 76, 118, 39, 6, 74,
		// -17, 52, -16, -36, 100, 122, 52, -12, -42, -33, -1, 54, 101, 96, -26, 27, -1,
		// -21, 111, 1, 93, 84, 32, 74, -78, 80, 72, -105, 75, -52, 32, 113, -119, 0,
		// 17, 115, 115, -10, -12, 17, 22, 114, 71, -90, -123, -30, -99, 24, -58, -23,
		// 53, -73, 54, 69, 49, -77, 16, 10, 2, -117, -125, -30, 81, 41, -96, 2, -21,
		// -59, -116, 58, -55, -96, 31, 20, -96, -80, 18, -113, 37, -82, 36, 31, 70,
		// -43, 7, -108, -11, 40, -91, -125, -55, -54, -82, 75, -31, -35, 12, -22, 43,
		// -20, -107, -113, -22, 24, -61, -13, 29, -109, -69, 107, -128, 17, -76, 101,
		// 41, 107, 2, -69, 85, 31, -5, -69, 103, 127, -22, -24, -120, -53, -108, 105,
		// -26, -22, 112, -69, 9, -9, 7, 87, 92, -113, 18, -11, 70, -127, -29, 73, -39,
		// 78, 105, -3, 65, -97, -118, 79, 62, 100, 116, -27, 21, 4, -100, 100, -65,
		// -85, -61, 117, -5, 93, 97, 124, -53, 17, 7, -28, -60, 1, 60, -22, -25, 55,
		// -2, 45, 80, -120, 85, -98, -126, -119, -93, 2, 3, 1, 0, 1, 2, -126, 1, 0, 36,
		// -25, 101, -101, 64, 56, 0, 44, 38, 37, 9, 95, 76, -28, -17, -55, 83, -93,
		// 104, 81, -4, 55, 103, 22, -115, -109, -94, 74, -111, 13, 74, 78, -81, 81,
		// -123, 59, -111, -124, 36, 76, -25, 101, -15, -127, -110, -6, 19, 113, -118,
		// 11, 49, -51, -2, -89, 112, 25, -45, 106, 65, -55, 86, -103, 28, -54, 74,
		// -125, -10, -87, -70, -47, -109, 127, -13, -54, -24, 98, -77, 121, 32, 83,
		// -39, -118, -103, 88, -30, 36, -44, 7, -62, 9, -46, 86, -123, -125, 100, -88,
		// 25, 120, -125, 107, -91, -72, 45, -73, -98, -52, -93, 114, 104, 91, -115, 6,
		// -115, 72, 35, -58, 120, 26, 110, -80, 87, 59, 46, 38, -74, 11, 24, -54, -44,
		// -96, -41, 54, 122, 44, 34, 74, -79, -40, 86, -73, 116, -55, -107, -76, 101,
		// 12, 111, 78, 1, -81, -30, -9, 109, 18, -6, -29, 123, -53, -1, 38, -85, 125,
		// 83, -57, -52, -79, -29, -100, 124, -49, -29, -104, 92, 32, -33, -40, 4, 53,
		// 79, 125, 123, 34, -36, 34, -3, -6, -45, 93, 79, -9, -82, -10, -116, -36, -30,
		// 80, -119, 56, -36, -65, 3, 102, -86, 62, -18, -45, -35, 51, 126, -29, -52,
		// -86, -39, 39, -26, 9, 13, 16, 61, 66, -34, -72, 82, -18, -43, -10, -63, 5,
		// 25, 117, 118, 49, -75, 52, 69, -77, 38, -1, 99, 48, 80, 1, -106, -104, -48,
		// -52, 9, -98, -70, 20, 116, -122, -90, -72, 64, 1, 2, -127, -127, 0, -7, -106,
		// 114, -57, -34, 22, 24, 93, 78, -35, 87, -70, -17, 25, 14, 41, 6, -97, -6, 89,
		// -55, -1, -80, -92, -55, 1, -8, -119, 102, 110, -119, 25, -19, -24, 17, -25,
		// 96, 31, -80, -6, -126, -87, 17, 1, -28, -110, 23, 7, -66, -22, 88, -80, 116,
		// 94, 117, 30, 101, 57, 121, 120, 72, -54, 123, -32, -62, -5, -97, 76, -72, 45,
		// 23, -96, -79, -72, -14, -76, -116, 123, -7, 38, -1, -66, 16, -15, -108, -124,
		// 87, -103, 127, 108, -121, -114, 7, -105, 10, -93, 34, 33, 33, -86, -96, 29,
		// 102, 33, 12, -75, -97, 21, -4, 97, -19, -41, -86, 64, -2, -118, 92, 104, -73,
		// -13, -40, 62, 86, -128, 81, 18, -107, 1, 2, -127, -127, 0, -84, -89, -80, 40,
		// 57, -30, 72, 109, -39, -97, -70, -74, 11, 72, -70, 119, 6, -125, 15, 29, 69,
		// -21, -43, -110, -7, 96, -124, 23, -72, 41, -66, 28, 113, -36, 40, -113, -108,
		// 108, 76, 116, 70, 12, -111, -106, -70, -38, 61, -118, -116, -3, 35, -34, -80,
		// -19, -27, 64, -50, 115, 37, 58, 104, -117, -18, 30, -65, 37, -76, 78, -26,
		// -107, 58, 39, -42, 120, -81, 69, 59, 110, -23, 8, -119, 91, -61, 91, 21, 90,
		// -82, 26, 69, -127, -86, -66, -58, 80, 95, 100, -76, 7, 110, -76, -36, 27,
		// 111, -78, -66, 30, 126, 78, 32, 75, 78, -49, -121, -69, -24, -111, -19, 13,
		// -75, 113, 118, -16, 75, -109, -47, -69, -86, -93, 2, -127, -127, 0, -38,
		// -121, -42, 60, 21, -62, 54, -41, 12, 4, 85, -102, 65, 91, 40, -64, -41, 34,
		// 31, -85, -102, 104, 28, 28, 76, 59, 67, -121, -38, 126, 17, -32, -8, 35, 103,
		// -7, -76, 122, 75, 21, 44, 110, 39, -116, 6, -69, -69, 26, 119, 24, -19, 74,
		// -94, -71, 73, -58, -79, 78, -97, -126, -88, 9, 82, 105, -69, -113, 97, 45,
		// 101, 93, 102, 0, -73, 91, 126, 118, -125, 66, -47, 38, 74, 105, -6, -97, -21,
		// 47, -19, 27, 99, 44, 125, -117, -24, 45, 97, -116, -16, -121, 29, -39, 45,
		// -108, 80, 37, -61, -31, 10, 71, -49, -47, 86, -44, -84, 39, 120, 55, 97, 45,
		// -9, 82, -76, 21, -16, -37, 45, 33, 30, 1, 2, -127, -128, 111, 45, 87, -48,
		// -65, 93, 71, -40, 124, -81, 79, 82, -108, 55, -109, -30, -69, 45, -65, -104,
		// -47, 2, -120, -73, -88, -97, -114, -49, -101, 70, 61, -26, 33, 39, 108, 114,
		// -16, 87, 64, 112, 10, -1, 98, -20, -107, -117, -100, -33, 79, -28, 93, -87,
		// -77, 114, -83, 18, 43, 30, -104, 85, 97, 38, -30, 1, -88, -126, -123, -11,
		// -36, -93, 49, 28, -96, 13, 124, -121, 111, 58, -1, 18, 1, 41, 54, -59, -69,
		// 29, 118, 72, -14, -125, 9, -56, -24, -8, -82, 68, -79, 108, -85, -52, 8,
		// -124, 30, 76, 18, 2, -98, -64, 126, 41, 32, 41, -96, -76, -50, -112, -48, -3,
		// -25, -35, -107, -126, 44, -104, -106, 16, 107, 83, 2, -127, -128, 109, -50,
		// -8, -105, 64, -38, -55, 121, -40, -16, 2, 103, 37, 120, 103, 92, 14, 116, 1,
		// -67, 3, 118, 90, 43, 45, 51, -80, -6, -45, -105, 95, -40, -74, -75, -47, 8,
		// 70, 116, -3, -127, 84, 112, 113, -64, 70, 57, 120, 103, -107, 13, 29, 125,
		// 124, -63, 105, 60, -81, 101, 87, -106, -110, -98, 10, 44, 59, -67, -66, -83,
		// 67, -5, 28, 103, 69, 117, 81, -62, 17, 108, -18, 103, 28, -104, 121, 40, 77,
		// 44, 14, 61, -30, 118, 84, -110, -8, 2, -51, -122, -126, -16, 111, -43, 90,
		// -69, -48, 68, 127, 127, 76, -7, -105, -114, 125, -68, 89, -68, -109, 123,
		// -11, -26, -95, 99, -2, 38, 54, -5, 17, 91, 30, 114]
		PrivateKey privateKey = keyPair.getPrivate();
		LogUtil.log(privateKey.getAlgorithm());
		byte[] privateKeyData = privateKey.getEncoded();
		List<Byte> privateKeyDataList = TypeUtil.createList();
		for (byte b : privateKeyData) {
			privateKeyDataList.add(b);
		}
		LogUtil.log(privateKeyDataList);
		LogUtil.log(privateKey.getFormat());

		PublicKey publicKey = keyPair.getPublic();
		LogUtil.log(publicKey.getAlgorithm());
		byte[] publicKeyData = privateKey.getEncoded();
		List<Byte> publicKeyDataList = TypeUtil.createList();
		for (byte b : publicKeyData) {
			publicKeyDataList.add(b);
		}
		// [48, -126, 4, -68, 2, 1, 0, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1,
		// 1, 5, 0, 4, -126, 4, -90, 48, -126, 4, -94, 2, 1, 0, 2, -126, 1, 1, 0, -96,
		// 86, 7, 28, -78, 102, -24, -125, 126, -33, 6, 104, 52, -29, 27, -101, 102,
		// 114, -4, 37, 85, -57, -55, 5, -51, -77, -95, 51, 108, 2, 106, 56, 70, -20,
		// -49, 64, -54, 101, 62, 55, 120, -47, 113, 7, -72, -41, 88, 108, -106, 14, 63,
		// 97, -116, 124, -58, -108, -34, -115, -79, 8, -39, -48, 4, -86, -127, -9, 99,
		// 114, -18, -42, 68, 44, -98, -2, 104, 54, -120, 119, -98, -47, 86, 51, 54,
		// -73, -37, 119, 58, 117, 77, -4, -122, 4, 100, -112, -14, -50, -71, -88, -82,
		// -100, 64, -95, -107, -7, -15, 113, 48, 48, 45, 32, 38, 9, 9, -44, 60, 120,
		// -112, 35, 39, -25, -102, 20, -61, -115, 127, -113, -23, 126, -66, 31, -75,
		// -20, 70, -116, -23, -12, -20, 14, 20, 116, -127, 89, 80, 110, -106, 94, 6,
		// -34, -17, 42, 71, -98, 45, 66, 114, -65, -59, -11, 93, 89, -96, -118, 61,
		// -96, -14, -70, -59, 88, 113, 1, -59, 2, -120, 66, -49, -47, 68, 97, 43, 57,
		// 103, 52, -125, -106, 115, 119, -8, 86, 82, 9, 95, 42, -49, -40, 122, 22, -22,
		// 5, -14, -2, -46, 126, 56, -107, -76, -40, 69, 112, -34, 6, -20, 25, 53, -15,
		// 36, 7, -2, 59, -92, 53, -30, -68, -34, 105, -77, -108, 41, 56, -102, 16, -11,
		// 39, -50, 43, -25, 124, 57, 73, 106, 40, -30, -76, 41, -80, -124, 31, -99,
		// -36, -73, 72, -107, -123, -18, 11, 87, -125, 2, 3, 1, 0, 1, 2, -126, 1, 0,
		// 40, 119, -82, 17, -37, 33, 72, 28, 48, 64, 96, 32, -101, 0, -101, 46, 44,
		// -68, 102, -47, -111, -123, -4, 65, -65, -70, 79, -68, 103, -51, 112, 59, -58,
		// 2, -19, 8, 96, 77, 15, 87, -10, -31, 125, -46, -62, 31, 112, 12, -16, 14,
		// -90, -122, -101, 107, -66, -65, 66, 48, -90, -9, 33, -22, 115, -45, 9, 60,
		// -124, 88, 52, -39, -43, -103, 33, -125, -6, -113, -111, 0, 8, 16, -77, -35,
		// -9, 56, -114, 102, -40, 85, 85, 26, -96, 68, -87, -111, 64, 7, 87, 42, -80,
		// -17, 117, 12, -109, -118, -29, 26, 123, 92, 29, 119, -104, -63, -3, 62, 25,
		// 9, 32, -16, 14, -103, 80, -11, 94, -87, -17, 1, 70, -96, 51, -109, 127, -79,
		// 12, -82, -63, 50, 25, -22, 64, 115, 62, 115, -29, 44, 36, 72, -119, -20, -9,
		// -53, -86, -7, -127, 79, 120, -55, 90, 115, 23, -103, 33, -34, -2, -124, 21,
		// 29, 82, -57, 114, -114, -123, 72, -89, -20, 26, 103, -97, -35, 40, 87, -90,
		// -54, 10, 66, 32, -83, -108, -40, 30, -39, -111, -93, -46, -124, 67, 120, -96,
		// 126, 52, 54, 68, 125, -50, 97, 89, -127, 77, 31, -87, -5, 13, 3, 123, -18, 8,
		// 9, 36, 94, -85, 99, 29, 112, 41, 24, -8, 115, 110, -35, -2, 46, 110, 107, 64,
		// 70, -37, -11, -110, 8, 38, 56, -12, 43, 50, 13, -23, 4, 76, 30, 124, -45, 37,
		// -106, 58, -97, 30, 9, 2, -127, -127, 0, -12, 49, 1, 2, 2, 6, -102, -47, -47,
		// 17, 1, -111, 93, 86, -2, -101, 50, -110, -89, 94, -21, -96, 74, 53, -20, 114,
		// -13, -25, -40, -117, 35, -58, -59, -57, 77, -12, 120, -32, 15, -20, -106, 29,
		// -11, -30, 92, -117, 89, 95, -106, 20, -61, -44, 18, -91, -97, -114, -115,
		// -55, -115, -77, -52, 115, 53, -119, -88, -97, -36, 17, -25, -77, -87, -67, 6,
		// 1, -118, -26, -73, -46, 33, 67, -120, -7, 50, 117, -41, 103, -66, 101, 104,
		// -76, 80, 62, 58, -113, -65, -31, -101, 53, 87, -81, 4, 58, -58, 119, -124,
		// -89, -5, 2, -40, 110, -128, -17, -12, -50, 41, 47, -99, -78, -103, -112, 23,
		// -31, 20, 30, 110, -128, -37, 13, 2, -127, -127, 0, -88, 22, -19, 46, 12, -65,
		// -22, 79, 6, -51, 46, -24, 107, 114, -116, 4, -123, 114, 25, -87, 79, 89, 121,
		// 87, -120, -81, 69, -127, 73, 3, -68, -52, 12, -108, 56, -72, -8, -83, -9,
		// -102, 107, 81, -94, 89, 78, -70, -119, -105, -53, -71, 23, -15, 1, 100, 36,
		// -76, -110, 88, 4, 126, 71, -73, 46, -85, 57, -30, 125, 89, -106, -6, 74, 77,
		// 89, 86, -38, -5, 62, 107, 29, -12, -69, 123, -104, 35, 104, -86, 124, -103,
		// -114, 14, 105, -113, -116, 68, 123, 20, -119, -89, 78, 113, 120, -53, -71,
		// -17, -10, -121, 15, -44, -20, 81, -24, 74, -52, 127, 87, 115, 47, -56, 59,
		// -4, -33, 68, 78, 27, -44, 85, 24, -49, 2, -127, -128, 53, 55, 0, -85, 57, 89,
		// -53, 31, 114, 90, 44, 103, 75, 90, 11, -2, 50, 85, 55, 88, 62, 45, 30, 63, 6,
		// 26, 63, 1, 5, 117, -67, 4, 50, 81, -82, -79, 90, 46, 42, 10, 58, -28, -88,
		// -110, -3, -21, -8, 60, 22, 110, -52, 6, 73, 82, 2, -91, -124, 76, -86, 46,
		// -58, -99, 76, -53, -123, 13, -31, 93, -99, -118, -49, -80, -69, -64, 86, 78,
		// -43, 60, 91, -73, 102, 0, 56, 120, -23, -54, 87, -7, -83, -119, -83, -5, 1,
		// -76, 21, -14, -54, 106, 35, -125, -90, 126, 80, -123, -9, 72, -52, 48, -32,
		// -115, -92, 87, -90, -105, -50, -19, -21, -123, -30, 101, 62, 110, -12, 125,
		// 117, 67, 107, 121, 2, -127, -128, 60, 68, -116, 33, -8, -68, 78, -4, -86,
		// -55, -94, -55, -2, -52, -127, 91, -107, -91, 69, -126, 41, 75, 65, 112, -101,
		// 55, -116, -54, 64, 45, -80, -31, -48, -104, -52, -123, -75, -44, 90, 116,
		// -23, -119, -55, -106, 15, -34, 94, 59, 40, -10, 98, -103, 45, 16, -123, 0,
		// -95, -128, 33, -116, 77, -106, 102, -117, 74, 35, -27, 33, -36, 58, 61, -83,
		// -30, 28, 124, 67, -99, 43, -74, -1, -22, -64, -13, -39, -82, 75, -126, -123,
		// 100, 35, -46, -63, 127, 95, -122, 105, -28, -71, 50, 45, 9, 76, -78, -116,
		// 81, 110, 55, -60, -10, 62, -97, -11, 65, -63, 94, -49, -108, 16, 77, 65, -21,
		// -93, -120, 5, -2, 105, -52, -115, 2, -127, -128, 3, -11, -78, 68, 29, 116,
		// 35, 125, -53, -46, -76, -75, 46, -71, -16, 122, -65, 97, -31, -79, 106, -106,
		// -14, 69, -56, -102, 23, 27, 77, 25, -85, -66, 73, 63, -51, -85, 76, 0, 12,
		// 121, 81, -66, -119, 76, -77, -87, -107, 117, 69, -26, 16, -42, -60, -32, -29,
		// 6, -56, 79, 63, -67, 72, 75, -56, -10, 123, -96, -6, 41, -27, 73, 29, 65, 76,
		// 53, 58, -128, -101, 6, -14, 123, 0, 23, -92, -35, 72, 96, 81, -38, 105, 43,
		// -17, 7, 46, -3, -27, -29, 17, -75, 13, 63, 1, -83, -14, 87, 64, -23, 40,
		// -123, 36, -1, -122, 17, 106, 61, 86, -46, 113, 6, 94, 53, 73, -122, -70, -29,
		// 33, -113, -8, -117]
		// [48, -126, 4, -66, 2, 1, 0, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1,
		// 1, 5, 0, 4, -126, 4, -88, 48, -126, 4, -92, 2, 1, 0, 2, -126, 1, 1, 0, -89,
		// -127, -112, -82, -73, -68, -119, -94, -5, -23, 104, 76, -9, -63, -33, -102,
		// -122, -23, -34, 10, -121, 9, 123, 39, -94, 115, -119, 32, -48, 55, -75, 40,
		// -126, 85, -4, -112, 90, 99, 7, 110, 82, -103, -59, 107, 89, 0, -125, -8, -21,
		// -77, -118, -38, 116, -98, -123, -82, -72, -24, 4, 52, -47, -27, -3, -47,
		// -118, -101, -100, 72, -64, -88, 64, 11, 124, 17, -76, -8, -56, 105, 48, 8,
		// -94, 57, 73, 3, 6, -95, 5, 23, 1, -64, 98, -63, 28, -29, -52, -119, -44, 63,
		// -110, 61, 81, -34, -60, 126, 31, 0, -128, -78, -99, -111, -36, 102, 71, 23,
		// -76, -50, -115, -114, -7, 95, -92, -65, -98, 120, 11, -29, -23, -58, 98, -24,
		// 114, 4, -29, -26, -120, -10, 113, 116, -39, -42, 73, 120, 20, 82, 108, -108,
		// 76, -30, 52, -120, -115, 21, 107, -95, -47, 92, -2, 94, -74, -124, 32, -28,
		// -101, 7, 91, -36, -89, 72, -55, 20, -78, 96, -73, -81, 51, 52, 4, 70, 60, -3,
		// 63, -19, -43, -120, -28, -69, -12, -117, -73, 125, 10, -39, 76, 90, -54, -12,
		// -51, 6, -24, -75, 45, 112, 47, -102, 70, -31, -98, 105, 74, 66, 51, -33, 41,
		// -123, 38, 96, 16, -87, 23, 125, -32, 101, 69, -107, -51, 108, -28, -128, -59,
		// 20, -93, -53, -88, -60, 28, -62, -113, -11, 103, -84, 126, -4, -80, 5, -54,
		// 104, 34, 11, -98, 46, 97, 31, 13, -37, -41, -41, 2, 3, 1, 0, 1, 2, -126, 1,
		// 0, 44, -128, 52, 114, -26, 103, 85, 93, -110, 117, 96, -5, 73, -69, 28, -17,
		// -115, -74, 38, 2, 63, -5, -39, -41, 30, -58, 121, 0, -39, -80, 99, 21, 127,
		// 2, -33, 21, 110, -99, -18, -124, 117, -73, 90, -122, 121, 95, -76, -81, -11,
		// -42, 126, 38, 41, 99, 79, -6, -86, 47, 33, -90, -14, -72, -102, 101, 7, -32,
		// -19, 117, 58, -111, -72, 106, 20, -83, 19, -102, 32, -116, 41, 113, -79, -65,
		// 108, 81, 60, 122, -100, -62, -114, -7, -112, -126, -29, 108, -11, -109, 12,
		// 107, 83, 43, -83, 75, 116, -126, 89, 52, 37, -4, -51, -11, -55, 74, -10, -54,
		// 42, -125, -47, -127, -47, 104, -126, 121, 81, -35, 108, -77, 65, 16, -65, 88,
		// -27, -67, 58, -72, 36, 17, -57, 89, -9, 99, 34, -61, -72, -16, -40, -80, 124,
		// 94, 53, 77, 109, -125, -85, -117, 28, 115, -114, 38, 19, -97, -33, 37, 55,
		// -121, 64, 98, 67, 49, 95, -23, 5, -94, 86, 122, 62, -16, 112, 97, -10, -17,
		// -70, 4, 91, -128, -24, 66, 28, -123, -126, -69, -108, 60, -78, -106, 62, 91,
		// -39, -123, 77, 46, -46, 42, -25, 65, -103, 70, 61, -84, 48, -107, -100, -74,
		// -43, 120, 41, 108, -54, 77, 28, 127, 10, 71, 0, 97, 112, -55, 61, -63, 36,
		// 13, -6, 107, 3, 88, 56, -86, 102, -127, -16, -61, -80, -7, 101, -60, -93,
		// 116, 52, -81, -63, -25, -25, 66, 36, -15, -30, 9, 2, -127, -127, 0, -17, 86,
		// 83, -121, -112, 22, 34, -59, 35, 45, -114, 63, -57, -87, 11, 102, 104, -43,
		// -82, 22, -104, 72, 33, -13, 77, 39, -88, -49, -31, 14, 1, 98, -28, -79, -16,
		// -23, 4, 49, 87, 19, -118, 71, 38, -99, 84, 14, 99, -77, -19, -70, 99, -128,
		// -32, 30, -99, -101, 25, 94, 113, -4, -53, 45, 7, -58, 120, 127, 25, 97, -110,
		// 51, -57, 5, 107, 59, 43, 86, 17, -69, -97, 61, -107, 127, 103, 56, -33, -30,
		// -66, -74, 18, -88, -31, -37, -49, -11, -76, -51, 104, -93, 65, -64, -78, -15,
		// -115, 100, -68, -3, -106, -72, -46, -24, -105, 32, 61, 61, -93, -84, -104,
		// -120, 51, 21, -38, 83, -61, 87, -101, -94, -29, 115, 2, -127, -127, 0, -77,
		// 43, 0, -44, -65, 44, 38, -76, 104, -54, -39, -105, 99, 20, -80, 94, -72,
		// -117, -5, 42, -111, -58, 4, 11, -14, 15, -61, -38, 87, -90, 27, -96, -84, 37,
		// -36, -38, 87, 60, 56, -107, -59, 115, 73, -18, 89, -56, 117, -104, 16, -125,
		// 17, 36, 126, 54, -8, -21, -48, 29, 58, -19, -37, -33, 117, 84, 70, 86, -35,
		// 73, 107, -74, 13, 127, 63, 67, 92, 100, 19, -96, -116, -55, 123, -28, 43,
		// -17, 118, -89, -10, -32, 22, -1, 122, 49, 74, -8, 30, -34, -108, 31, 85, 103,
		// -79, 27, -96, 62, -3, 125, 84, -123, -47, 70, -33, -55, 52, -65, 73, -117,
		// 16, -72, -110, 12, -45, 110, 7, -103, 47, -69, -55, 13, 2, -127, -127, 0,
		// -46, 114, 91, -68, 69, -85, -47, 34, -6, -51, -95, -40, -33, 28, -5, 19, 47,
		// 119, 68, 62, 69, -28, -105, 69, -78, 63, -1, 37, -38, -60, 79, -33, -65, 43,
		// -33, -93, 100, -74, 101, -44, -98, -81, -11, 122, 61, 96, -15, -74, 82, -128,
		// -93, -31, -68, 47, -17, 113, 99, -101, 50, 43, -112, 19, -90, 84, -109, -69,
		// 94, 123, -10, -20, 100, 65, -107, -118, 79, -114, -68, -60, -9, 62, 85, 103,
		// -45, 65, -91, 75, 97, 90, 3, -118, 80, 30, -47, -5, 64, -31, -92, -14, 120,
		// 108, -110, 107, -25, 97, -2, -12, 20, 69, -85, -34, 44, -108, -126, -124,
		// -30, -104, 110, -2, -61, -68, -95, 95, 41, -46, -84, -35, 75, -107, 2, -127,
		// -128, 55, 91, -115, 25, 46, -84, 28, -107, 87, 95, 125, -107, 121, -58, -107,
		// -85, -34, -121, 89, -90, 80, 126, 7, 24, 13, -59, 115, 53, 14, 41, -61, -107,
		// -124, 58, -6, -98, -9, -97, 34, -72, -101, -42, 64, 60, -123, -65, 27, 30,
		// 77, -45, -63, 67, 46, 64, 27, -18, -8, 81, 95, -72, -56, 91, -91, -85, -47,
		// 67, -37, -127, 104, -25, 74, 10, 75, -24, -85, 46, 60, -90, 57, 121, -77,
		// 110, -49, 104, 96, -104, 10, -2, 55, -4, -35, -85, 71, 71, -100, 122, 22, -8,
		// 11, 114, 75, 85, -122, -48, -113, -113, -34, -62, -83, -29, -95, 23, 80, -43,
		// -35, -118, 59, 51, 91, -28, -36, -102, -67, 124, 70, 52, 86, 45, 2, -127,
		// -127, 0, -97, 86, 105, 100, 16, -49, 89, 6, 69, -125, 64, 47, -126, -32, 107,
		// 35, -128, -57, -3, -103, 125, -99, -81, -91, -71, -47, 70, -82, -52, 29,
		// -103, 53, -73, 118, -89, 105, 87, 104, -31, -88, 48, -96, 17, -28, 11, -38,
		// -25, -3, 63, -58, 93, 12, 4, -128, -54, 61, 82, -29, 17, 87, -22, -99, 31,
		// -4, -2, -104, -83, -23, 62, 18, 88, -23, -84, -81, -121, 57, -61, -37, -26,
		// -34, -65, -89, -9, 19, 104, -11, 98, 119, -86, 16, -55, 66, -35, 16, -13,
		// -124, -79, 18, -89, 16, -10, -50, 47, 34, 96, 68, -20, 123, 120, -89, -84,
		// 54, 78, 40, 23, 6, 64, 112, 22, 111, -59, 82, -75, -92, -21, 30, 93, -28]
		LogUtil.log(publicKeyDataList);
		LogUtil.log(publicKey.getFormat());

		X509CertInfo xci = new X509CertInfo();

		ks.setKeyEntry("证书例子", privateKey, "123456".toCharArray(), new X509Certificate[] { xci });

		LogUtil.log(ks.getType());
		LogUtil.log(ks.getProvider());
		LogUtil.log(ks.aliases());
		LogUtil.log(Collections.list(ks.aliases()));

		ks.store(new FileOutputStream("demo.keystore"), "12".toCharArray());
	}

}



class X509CertInfo extends X509Certificate {

	private int version;
	private BigInteger serialNumber;	
	private String signedAlgorithm;
	private String signedHashAlgorithm;	
	private String issuer;
	private Date notBefore;
	private Date notAfter;
	private String subject;	
	private PrivateKey privateKey;
	private PublicKey publicKey;
	private String fingerAlgorithm;
	private byte[] finger;
	
	
	
	public X509CertInfo() {
		
	}
	
	@Override
	public boolean hasUnsupportedCriticalExtension() {
		return false;
	}

	@Override
	public Set<String> getCriticalExtensionOIDs() {
		Set<String> set = new TreeSet<String>();
		set.add(UUID.randomUUID().toString());
		return set;
	}

	@Override
	public Set<String> getNonCriticalExtensionOIDs() {
		Set<String> set = new TreeSet<String>();
		set.add(UUID.randomUUID().toString());
		return set;
	}

	@Override
	public byte[] getExtensionValue(String oid) {
		/**
		 * 2.5.29.14 SubjectKeyIdentifier 2.5.29.15 KeyUsage 2.5.29.16 PrivateKeyUsage
		 * 2.5.29.17 SubjectAlternativeName 2.5.29.18 IssuerAlternativeName 2.5.29.19
		 * BasicConstraints 2.5.29.30 NameConstraints 2.5.29.33 PolicyMappings 2.5.29.35
		 * AuthorityKeyIdentifier 2.5.29.36 PolicyConstraints
		 *
		 */
		return "2.5.29.14".getBytes();
	}

	@Override
	public void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
		// TODO Auto-generated method stub
	}

	@Override
	public void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getVersion() {
		return 2;
	}

	@Override
	public BigInteger getSerialNumber() {
		SecureRandom rng = new SecureRandom();
		byte[] randomBytes = new byte[64];
		rng.nextBytes(randomBytes);
		return new BigInteger(randomBytes);
	}

	@Override
	public Principal getIssuerDN() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Principal getSubjectDN() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getNotBefore() {
		return new Date();
	}

	@Override
	public Date getNotAfter() {
		return new Date();
	}

	@Override
	public byte[] getTBSCertificate() throws CertificateEncodingException {
		SecureRandom rng = new SecureRandom();
		byte[] randomBytes = new byte[64];
		rng.nextBytes(randomBytes);
		return randomBytes;
	}

	@Override
	public byte[] getSignature() {
		SecureRandom rng = new SecureRandom();
		byte[] randomBytes = new byte[64];
		rng.nextBytes(randomBytes);
		return randomBytes;
	}

	@Override
	public String getSigAlgName() {
		return "SHA256withRSA";
	}

	@Override
	public String getSigAlgOID() {
		return "1.2.840.10040.4.3";
	}

	@Override
	public byte[] getSigAlgParams() {
		SecureRandom rng = new SecureRandom();
		byte[] randomBytes = new byte[64];
		rng.nextBytes(randomBytes);
		return randomBytes;
	}

	@Override
	public boolean[] getIssuerUniqueID() {
		return new boolean[] { true, false };
	}

	@Override
	public boolean[] getSubjectUniqueID() {
		return new boolean[] { true, false };
	}

	@Override
	public boolean[] getKeyUsage() {
		return new boolean[] { true, false };
	}

	@Override
	public int getBasicConstraints() {
		return 100;
	}

	@Override
	public byte[] getEncoded() throws CertificateEncodingException {
		SecureRandom rng = new SecureRandom();
		byte[] randomBytes = new byte[64];
		rng.nextBytes(randomBytes);
		return randomBytes;
	}

	@Override
	public void verify(PublicKey key) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException,
			NoSuchProviderException, SignatureException {
		// TODO Auto-generated method stub

	}

	@Override
	public void verify(PublicKey key, String sigProvider) throws CertificateException, NoSuchAlgorithmException,
			InvalidKeyException, NoSuchProviderException, SignatureException {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PublicKey getPublicKey() {
		return null;
	}

}