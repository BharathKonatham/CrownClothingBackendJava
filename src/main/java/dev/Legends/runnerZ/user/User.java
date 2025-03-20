package dev.Legends.runnerZ.user;

public record User(
        Integer id,
        String name,
        String userName,
        String email,
        Address address,
        String phone,
        String website,
        Company company
) {
}
