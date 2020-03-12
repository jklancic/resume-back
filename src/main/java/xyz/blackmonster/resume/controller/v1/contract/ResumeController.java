package xyz.blackmonster.resume.controller.v1.contract;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

public interface ResumeController {

    ResponseEntity<Resource> getResume();
}
