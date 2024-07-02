import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class PasswordManager<K,V> implements Map<K,V> {
    private static final String MASTER_PASSWORD = "password321";
    private Account[] _passwords;

    public PasswordManager() {
        _passwords = new Account[50];
    }


    //put
    @Override
    public void put(K key, V value) {
        int i = Math.abs(key.hashCode() % _passwords.length);
        if(_passwords[i] == null){
            _passwords[i] = new Account<>(key,value);
        } else {
            Account<K, V> current = _passwords[i];
            while (current.getNext() != null && !current.getWebsite().equals(key)) {
                current = current.getNext();
            }
            if (current.getWebsite().equals(key)) {
                current.setPassword(value);
            } else {
                current.setNext(new Account<>(key, value));
            }
        }
    }

    //get
    @Override
    public V get(K key) {
        int i = Math.abs(key.hashCode() % _passwords.length);

        Account<K, V> current = _passwords[i];
        while (current != null) {
            if (current.getWebsite().equals(key)) {
                return current.getPassword();
            }
            current = current.getNext();
        }
        return null;
    }

    //size
    @Override
    public int size() {
        int count = 0;
        for (Account<K, V> account : _passwords) {
            if (account != null) {
                Account<K, V> current = account;
                while (current != null) {
                    count++;
                    current = current.getNext();
                }
            }
        }
        return count;
    }

    //keySet
    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for (Account<K, V> account : _passwords) {
            if (account != null) {
                Account<K, V> current = account;
                while (current != null) {
                    keys.add(current.getWebsite());
                    current = current.getNext();
                }
            }
        }
        return keys;
    }

    //remove
    @Override
    public V remove(K key) {
        int i = Math.abs(key.hashCode() % _passwords.length);

        Account<K, V> current = _passwords[i];
        Account<K, V> prev = null;

        while (current != null) {
            if (current.getWebsite().equals(key)) {
                if (prev == null) {
                    _passwords[i] = current.getNext();
                } else {
                    prev.setNext(current.getNext());
                }
                return current.getPassword();
            }
            prev = current;
            current = current.getNext();
        }

        return null;
    }

    //checkDuplicate
    @Override
    public List<K> checkDuplicate(V value) {
        List<K> duplicates = new ArrayList<>();
        for (Account<K, V> account : _passwords) {
            if (account != null) {
                Account<K, V> current = account;
                while (current != null) {
                    if (current.getPassword().equals(value)) {
                        duplicates.add(current.getWebsite());
                    }
                    current = current.getNext();
                }
            }
        }
        return duplicates;
    }

    //checkMasterPassword
    @Override
    public boolean checkMasterPassword(String enteredPassword) {
        return MASTER_PASSWORD.equals(enteredPassword);
    }

    /*
    Generates random password of input length
     */
    @Override
    public String generateRandomPassword(int length) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = length;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    /*
    Used for testing, do not change
     */
    public Account[] getPasswords() {
        return _passwords;
    }
}