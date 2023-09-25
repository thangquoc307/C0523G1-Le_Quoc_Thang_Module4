package com.musicmanage.controller;

import com.musicmanage.dto.MusicDto;
import com.musicmanage.model.Music;
import com.musicmanage.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
public class MusicManageController {
    @Autowired
    IMusicService service;
    @GetMapping("/")
    public String showAllMusic(Model model){
        model.addAttribute("musicList", service.getAllMusic());
        return "/index";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("music", new MusicDto());
        return "create";
    }
    @PostMapping("/create")
    public String createNewMusic(@Valid @ModelAttribute MusicDto music,
                                 BindingResult bindingResult){
        new MusicDto().validate(music, bindingResult);
        if (bindingResult.hasErrors()){
            return "create";
        }
        Music newMusic = new Music();
        BeanUtils.copyProperties(music, newMusic);
        service.createMusic(newMusic);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable int id, Model model){
        model.addAttribute("music", service.getMusicById(id));
        return "edit";
    }
    @PostMapping("/edit")
    public String editMusic(@Valid @ModelAttribute MusicDto music,
                            BindingResult bindingResult){
        new MusicDto().validate(music, bindingResult);
        if (bindingResult.hasErrors()){
            return "edit";
        }
        Music newMusic = new Music();
        BeanUtils.copyProperties(music, newMusic);
        service.updateMusic(newMusic);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteMusic(@PathVariable int id){
        service.deleteMusicById(id);
        return "redirect:/";
    }
}
