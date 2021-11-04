package com.laptopshopping.laptopshopping.converter;

import com.laptopshopping.laptopshopping.dto.TagDTO;
import com.laptopshopping.laptopshopping.dto.TagDTOCreate;
import com.laptopshopping.laptopshopping.dto.TagDTOUpdate;
import com.laptopshopping.laptopshopping.model.Tag;
import org.dom4j.rule.Mode;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class TagConverter {
    @Autowired
    private ModelMapper modelMapper;

    private TagDTO convertToDto(Tag tag) {
        TagDTO tagDTO = modelMapper.map(tag, TagDTO.class);
        tagDTO.setTagId(tag.getTagId());
        return tagDTO;
    }

    public Tag convertToEntity(TagDTO tagDTO) throws ParseException {
        Tag tag = modelMapper.map(tagDTO, Tag.class);
        return tag;
    }

    public Tag convertToEntityCreate(TagDTOCreate tagDTOCreate) throws ParseException {
        Tag tag = modelMapper.map(tagDTOCreate, Tag.class);
        return tag;
    }

    public Tag convertToEntityUpdate(TagDTOUpdate tagDTOUpdate) throws ParseException {
        Tag tag = modelMapper.map(tagDTOUpdate, Tag.class);
        return tag;
    }
}
