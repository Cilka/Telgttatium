package com.cilka.telgt.utils;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.*;

public class DefaultOptionsHandler extends SectionHandler {

    private String name;
    private String material;
    private String sound;
    private String renderLayer;
    private boolean isName = false;
    private boolean isMaterial = false;
    private boolean isSound = false;
    private boolean isRenderLayer =false;
    private Map<String,ModOptions> defaultModOptions = new HashMap<String,ModOptions>();
    public DefaultOptionsHandler(XMLReader reader) {
        super(reader);
    }
    @Override
    public void startElement(String uri,
                             String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("name"))
        {
            isName = true;
        }
        else if(qName.equalsIgnoreCase("material"))
        {
            isMaterial = true;
        }
        else if (qName.equalsIgnoreCase("soundType"))
        {
            isSound = true;
        }
        else if(qName.equalsIgnoreCase("blockRenderLayer"))
        {
            isRenderLayer = true;
        }
    }
    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if(isName)
        {
            name = new String(ch, start, length);
            isName =false;
        }    if(isMaterial)
        {
            material = new String(ch, start, length);
            isMaterial =false;
        }    if(isSound)
        {
            sound = new String(ch, start, length);
            isSound =false;
        }    if(isRenderLayer)
        {
            renderLayer = new String(ch, start, length);
            isRenderLayer =false;
        }

    }
    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException
    {
        try{
            if(material != null && sound != null && renderLayer != null) {
                defaultModOptions.put(name, new ModOptions(translateMaterial(), translateSoundType(), translateBlockRenderLayer()));
                System.out.println(name + " " + this.getClass().getSimpleName() + " complete");
            }
            }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    private Material translateMaterial() throws IllegalAccessException {
        Material m = (Material)Arrays.stream(Material.class.getFields())
                .filter( f-> f.getName().equalsIgnoreCase(material))
                .findFirst()
                .get()
                .get(Material.class.getFields());

        return m;
    }
    private SoundType translateSoundType() throws IllegalAccessException {
        SoundType m = (SoundType) Arrays.stream(SoundType.class.getFields())
                .filter( f-> f.getName().equalsIgnoreCase(sound))
                .findFirst()
                .get()
                .get(SoundType.class.getFields());

        return m;
    }
    private BlockRenderLayer translateBlockRenderLayer() throws IllegalAccessException {
        BlockRenderLayer m = (BlockRenderLayer) Arrays.stream(BlockRenderLayer.class.getFields())
                .filter( f-> f.getName().equalsIgnoreCase(renderLayer))
                .findFirst()
                .get()
                .get(BlockRenderLayer.class.getFields());

        return m;
    }
    }
