package com.backend.infocare.domain;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketAsserts {

    /**
     * Asserts that the entity has all properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertTicketAllPropertiesEquals(Ticket expected, Ticket actual) {
        assertTicketAutoGeneratedPropertiesEquals(expected, actual);
        assertTicketAllUpdatablePropertiesEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all updatable properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertTicketAllUpdatablePropertiesEquals(Ticket expected, Ticket actual) {
        assertTicketUpdatableFieldsEquals(expected, actual);
        assertTicketUpdatableRelationshipsEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all the auto generated properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertTicketAutoGeneratedPropertiesEquals(Ticket expected, Ticket actual) {
        assertThat(expected)
            .as("Verify Ticket auto generated properties")
            .satisfies(e -> assertThat(e.getId()).as("check id").isEqualTo(actual.getId()));
    }

    /**
     * Asserts that the entity has all the updatable fields set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertTicketUpdatableFieldsEquals(Ticket expected, Ticket actual) {
        assertThat(expected)
            .as("Verify Ticket relevant properties")
            .satisfies(e -> assertThat(e.getTitle()).as("check title").isEqualTo(actual.getTitle()))
            .satisfies(e -> assertThat(e.getDescription()).as("check description").isEqualTo(actual.getDescription()))
            .satisfies(e -> assertThat(e.getCreatedAt()).as("check createdAt").isEqualTo(actual.getCreatedAt()))
            .satisfies(e -> assertThat(e.getResolutionDate()).as("check resolutionDate").isEqualTo(actual.getResolutionDate()))
            .satisfies(e -> assertThat(e.getClosedAt()).as("check closedAt").isEqualTo(actual.getClosedAt()))
            .satisfies(e -> assertThat(e.getLimitDate()).as("check limitDate").isEqualTo(actual.getLimitDate()))
            .satisfies(e -> assertThat(e.getImpact()).as("check impact").isEqualTo(actual.getImpact()))
            .satisfies(e -> assertThat(e.getResolution()).as("check resolution").isEqualTo(actual.getResolution()))
            .satisfies(e -> assertThat(e.getAttachments()).as("check attachments").isEqualTo(actual.getAttachments()));
    }

    /**
     * Asserts that the entity has all the updatable relationships set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertTicketUpdatableRelationshipsEquals(Ticket expected, Ticket actual) {
        assertThat(expected)
            .as("Verify Ticket relationships")
            .satisfies(e -> assertThat(e.getApplicationUser()).as("check applicationUser").isEqualTo(actual.getApplicationUser()))
            .satisfies(e -> assertThat(e.getCategory()).as("check category").isEqualTo(actual.getCategory()))
            .satisfies(e -> assertThat(e.getStatus()).as("check status").isEqualTo(actual.getStatus()))
            .satisfies(e -> assertThat(e.getPriority()).as("check priority").isEqualTo(actual.getPriority()))
            .satisfies(e -> assertThat(e.getMaterial()).as("check material").isEqualTo(actual.getMaterial()));
    }
}