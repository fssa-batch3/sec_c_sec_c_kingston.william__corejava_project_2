# sec_c_sec_c_kingston.# Blood Request Table

This repository contains the SQL `CREATE TABLE` statement for a database table named `bloodrequest`. The table is designed to store information about blood donation requests.

## Table Schema

| Column          | Type         | Description                                      |
|-----------------|--------------|--------------------------------------------------|
| id              | int          | Primary key and unique identifier               |
| bloodType       | varchar(3)   | Blood type for the donation request             |
| description     | varchar(255) | Reason for the blood donation request           |
| contactNo       | varchar(20)  | Contact number of the requester                |
| reqDate         | date         | Date of the blood donation request             |
| reqVerification | varchar(20)  | Verification status of the request              |
| status          | varchar(6)   | Status of the blood donation request           |
| closedDate      | date         | Date when the request was closed               |

## SQL Statement

```sql
CREATE TABLE `bloodrequest` (
  `id` int NOT NULL AUTO_INCREMENT,
  `bloodType` varchar(3) NOT NULL,
  `description` varchar(255) NOT NULL,
  `contactNo` varchar(20) NOT NULL,
  `reqDate` date DEFAULT NULL,
  `reqVerification` varchar(20) NOT NULL,
  `status` varchar(6) NOT NULL,
  `closedDate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
);
william__corejava_project_2
