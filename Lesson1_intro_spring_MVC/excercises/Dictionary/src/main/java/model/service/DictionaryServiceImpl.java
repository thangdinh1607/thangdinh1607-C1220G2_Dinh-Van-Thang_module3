package model.service;

import model.repository.DictionaryRepository;
import model.repository.DictionaryRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired
    DictionaryRepositoryImpl dictionaryRepository;
    @Override
    public String search(String string) {
        return  dictionaryRepository.search(string);
    }
}

