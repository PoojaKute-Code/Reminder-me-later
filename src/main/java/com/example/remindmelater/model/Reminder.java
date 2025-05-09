
package com.example.remindmelater.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;
    private LocalDateTime remindAt;

    @Enumerated(EnumType.STRING)
    private RemindBy remindBy;

    public enum RemindBy {
        EMAIL,
        SMS
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public LocalDateTime getRemindAt() { return remindAt; }
    public void setRemindAt(LocalDateTime remindAt) { this.remindAt = remindAt; }

    public RemindBy getRemindBy() { return remindBy; }
    public void setRemindBy(RemindBy remindBy) { this.remindBy = remindBy; }
}
