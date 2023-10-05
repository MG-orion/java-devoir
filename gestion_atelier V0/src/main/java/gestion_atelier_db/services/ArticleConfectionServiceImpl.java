package gestion_atelier_db.services;


import java.util.ArrayList;

import gestion_atelier_db.entities.ArticleConfection;

import gestion_atelier_db.repositories.ITables;


public class ArticleConfectionServiceImpl implements ArticleConfectionService {
    //private TableArticleConfections tables=new TableArticleConfections();

    //couplage faible
    private ITables<ArticleConfection> articleConfectionRepository;



    //injection de dependance via le constructeur
    public ArticleConfectionServiceImpl(ITables<ArticleConfection> articleConfectionRepository) {
        this.articleConfectionRepository = articleConfectionRepository;
        
    }

    // injection de dependance via le setter
    public void setArticleConfectionRepository(ITables<ArticleConfection> articleConfectionRepository) {
        this.articleConfectionRepository= articleConfectionRepository;
    }

    @Override
    public int add(ArticleConfection data) {
       return articleConfectionRepository.insert(data);
    }

    @Override
    public ArrayList<ArticleConfection> getAll() {
        return articleConfectionRepository.findAll();
    }

    @Override
    public ArticleConfection get(int id) {
        return articleConfectionRepository.findById(id);
    }

     @Override
    public int update(ArticleConfection tables) {
        return articleConfectionRepository.update(tables);
    }
    

    @Override
    public ArticleConfection show(int id) {
       return articleConfectionRepository.findById(id);
    }

    @Override
    public int remove(int id) {
        return articleConfectionRepository.delete(id);
    }

    @Override
    public int[] remove(int[] ids) {
        int[] idsNotDelete=new int[ids.length];
        int nbre=0;
        for (int id = 0; id < ids.length; id++) {
            if (articleConfectionRepository.delete(id)==0){
                idsNotDelete[nbre++]=id;
            }
        }
        return idsNotDelete;
    }

    
    static void pause(){
        int millis = 3000;

        try {
            Thread.sleep(millis);
        } catch (InterruptedException ie) {
            // ...
        }
    }
}
