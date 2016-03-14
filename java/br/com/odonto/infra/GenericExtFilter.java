package br.com.odonto.infra;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author mnt
 * Filtrar arquivos pela extensao informada
 */
public class GenericExtFilter implements FilenameFilter {

    private String ext;

    public GenericExtFilter(String ext) {
        this.ext = ext;
    }

    public boolean accept(File dir, String name) {
        return (name.endsWith(ext));
    }
}
