package com.closetbot.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Owner on 11/2/2016.
 */
public abstract class ClothingArticle implements DecoratorWrapper {
    private Color color;
    private Pattern pattern;

    public void setColor(Color color) {
        this.color = color;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public abstract void setType(Type type);

    private Season season;
    private Type type;
    private static final long serialVersionUID = 6529685098267757690L;

    public ClothingArticle(Color c, Pattern p, Season s){
        color = c;
        pattern = p;
        season = s;
    }

    public void setClothingArticle(DecoratorWrapper article){
        this.article = article;
    }

    protected DecoratorWrapper article = null;

    @Override
    public List getClothingArticle() {
        List toRet = null;
        if( article != null ){
            toRet = article.getClothingArticle();
        }
        if( toRet == null ){
            toRet = new ArrayList<DecoratorWrapper>();
        }
        toRet.add(this);
        return toRet;
    }
    public Color getColor(){
        return color;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public Season getSeason() {
        return season;
    }

    public abstract Type getType();
}