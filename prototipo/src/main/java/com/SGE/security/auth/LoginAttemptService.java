package com.SGE.security.auth;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class LoginAttemptService {

    private static final int MAX_ATTEMPTS = 5;
    private static final long BLOCK_DURATION_MS = 24 * 60 * 60 * 1000; // 24 horas

    private final ConcurrentMap<String, AtomicInteger> attemptsCache;
    private final ConcurrentMap<String, Long> blockedCache;

    public LoginAttemptService() {
        this.attemptsCache = new ConcurrentHashMap<>();
        this.blockedCache = new ConcurrentHashMap<>();
    }

    public void loginFailed(String key) {
        AtomicInteger attempts = attemptsCache.get(key);
        if (attempts == null) {
            attempts = new AtomicInteger(0);
            attemptsCache.put(key, attempts);
        }
        attempts.incrementAndGet();

        if (attempts.get() >= MAX_ATTEMPTS) {
            blockedCache.put(key, System.currentTimeMillis());
            attemptsCache.remove(key);
        }
    }

    public void loginSucceeded(String key) {
        attemptsCache.remove(key);
        blockedCache.remove(key);
    }

    public boolean isBlocked(String key) {
        Long blockTime = blockedCache.get(key);
        if (blockTime == null) {
            return false;
        }

        if (System.currentTimeMillis() - blockTime > BLOCK_DURATION_MS) {
            blockedCache.remove(key);
            return false;
        }

        return true;
    }

    public int getRemainingAttempts(String key) {
        AtomicInteger attempts = attemptsCache.get(key);
        if (attempts == null) {
            return MAX_ATTEMPTS;
        }
        return MAX_ATTEMPTS - attempts.get();
    }
}