package com.example.demo.domain.campaign;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class CampaignAlarmvo {

	@Id @GeneratedValue
	private int campaignAlarmId;
	private String alarmContext;
	@Temporal(value= TemporalType.TIMESTAMP)
<<<<<<< HEAD:src/main/java/com/example/demo/domain/campaign/CampaignAlarmvo.java
	private Timestamp alarmSendTime;
	@Temporal(value= TemporalType.TIMESTAMP)
	private Timestamp alarmReceiveTime;
=======
	private Date alarmSendTime;
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date alarmReceiveTime;
>>>>>>> 진광:src/main/java/com/example/demo/domain/campaign/Campaignalarmvo.java
	private int advertisementId;
	private int userId;
	private int campaignId;
	
	
}
