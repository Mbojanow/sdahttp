package com.sdacademy.httpdemo.symmetricencryption;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class EncryptionDemo {
  public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
    final String inputPath = args[0];
    final String outputPath = args[1];
    final int mode = Integer.valueOf(args[2]);
    final long seed = Long.valueOf(args[3]);
    final EncryptionService encryptionService = new EncryptionService();

    encryptionService.process(inputPath, outputPath, mode, seed);
  }
}
