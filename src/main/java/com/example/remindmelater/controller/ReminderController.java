
package com.example.remindmelater.controller;

import com.example.remindmelater.model.Reminder;
import com.example.remindmelater.repository.ReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/reminders")
public class ReminderController {

    @Autowired
    private ReminderRepository repository;

    @PostMapping
    public Reminder createReminder(@RequestBody ReminderDTO dto) {
        Reminder reminder = new Reminder();
        reminder.setMessage(dto.getMessage());
        reminder.setRemindAt(dto.getRemindAt());
        reminder.setRemindBy(Reminder.RemindBy.valueOf(dto.getRemindBy().toUpperCase()));
        return repository.save(reminder);
    }

    public static class ReminderDTO {
        private String message;
        private LocalDateTime remindAt;
        private String remindBy;

        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }

        public LocalDateTime getRemindAt() { return remindAt; }
        public void setRemindAt(LocalDateTime remindAt) { this.remindAt = remindAt; }

        public String getRemindBy() { return remindBy; }
        public void setRemindBy(String remindBy) { this.remindBy = remindBy; }
    }
}
