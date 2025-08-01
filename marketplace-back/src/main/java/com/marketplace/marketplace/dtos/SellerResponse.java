package com.marketplace.marketplace.dtos;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.marketplace.marketplace.serializer.GenderSerializer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;

@JsonPropertyOrder({"id", "email", "lastname", "name"})
public class SellerResponse extends RepresentationModel<SellerResponse> implements Serializable {
        private static final long serialVersionUID = 1L;
        @JsonProperty("nome")
        private String name;
        @JsonProperty("sobrenome")
        private String lastName;
        @JsonIgnore
        private String email;
        @JsonFormat(pattern = "dd/MM/yyyy")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Date birthday;
        @JsonSerialize(using = GenderSerializer.class)
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String gender;

        public SellerResponse() {
        }

        public SellerResponse(String name, String lastName, String email, Date birthday, String gender) {
                this.name = name;
                this.lastName = lastName;
                this.email = email;
                this.birthday = birthday;
                this.gender = gender;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public Date getBirthday() {
                return birthday;
        }

        public void setBirthday(Date birthday) {
                this.birthday = birthday;
        }

        public String getGender() {
                return gender;
        }

        public void setGender(String gender) {
                this.gender = gender;
        }


}
