package service;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Service
public interface ServiceInterface {
    public List<String> getListaString();
}
