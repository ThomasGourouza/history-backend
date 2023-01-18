package com.history.backend.controlers;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.history.backend.models.database.Image;
import com.history.backend.services.ImageService;

@RestController
@CrossOrigin
@RequestMapping("/image")
public class ImageControler {

    @Autowired
    private ImageService imageService;

    @PostMapping("/")
    public String addImage(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("image") MultipartFile image,
            Model model) throws IOException {
        String id = imageService.saveImage(name, description, image);
        return "redirect:/image/" + id;
    }

    @GetMapping("/{id}")
    public String getImage(@PathVariable String id, Model model) {
        Image image = imageService.getImage(id);
        model.addAttribute("name", image.getName());
        model.addAttribute("description", image.getDescription());
        model.addAttribute("data",
                Base64.getEncoder().encodeToString(image.getBinary().getData()));
        return "image";
    }
    // Note that as we have the image data returned as a byte[], we'll convert it to a Base64 String to display it on the front-end.

}


// Let's start with uploadPhoto.html, which provides a simple form to upload an image:

// <html>
// <body>
// <h1>Upload new Photo</h1>
// <form method="POST" action="/photos/add" enctype="multipart/form-data">
//     Title:<input type="text" name="title" />
//     Image:<input type="file" name="image" accept="image/*" />
//     <input type="submit" value="Upload" />
// </form>
// </body>
// </html>

// Next, we'll add the photos.html view to display our photos:

// <html>
// <body>
//     <h1>View Photo</h1>
//     Title: <span th:text="${title}">name</span>
//     <img alt="sample" th:src="*{'data:image/png;base64,'+image}" />
// </body>
// </html>