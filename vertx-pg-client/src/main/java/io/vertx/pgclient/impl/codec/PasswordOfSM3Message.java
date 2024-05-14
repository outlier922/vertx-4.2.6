package io.vertx.pgclient.impl.codec;

import io.vertx.pgclient.impl.util.SM3Authentication;

import java.nio.charset.StandardCharsets;

class PasswordOfSM3Message {
  final String hash;

  PasswordOfSM3Message(String username, String password, byte[] salt) {
    byte[] digest = SM3Authentication.encode(username, password, salt);
    this.hash = salt != null ? new String(digest, StandardCharsets.US_ASCII) : password;
  }
}
