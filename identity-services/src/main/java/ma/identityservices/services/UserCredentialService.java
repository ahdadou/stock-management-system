package ma.identityservices.services;

import ma.identityservices.entities.UserCredential;
import ma.identityservices.exceptions.ResourceNotFoundException;
import ma.identityservices.repositories.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialService {
    @Autowired
    private UserCredentialRepository userCredentialRepository;

    public UserCredential createUserCredential(UserCredential userCredential) {
        return userCredentialRepository.save(userCredential);
    }

    public UserCredential getUserCredentialById(Long id) {
        return userCredentialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserCredential"));
    }

    public UserCredential updateUserCredential(Long id, UserCredential userCredentialDetails) {
        UserCredential userCredential = userCredentialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserCredential"));

        userCredential.setUsername(userCredentialDetails.getUsername());
        userCredential.setPassword(userCredentialDetails.getPassword());
        userCredential.setEmail(userCredentialDetails.getEmail());

        return userCredentialRepository.save(userCredential);
    }

    public void deleteUserCredential(Long id) {
        UserCredential userCredential = userCredentialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserCredential"));

        userCredentialRepository.delete(userCredential);
    }
}

