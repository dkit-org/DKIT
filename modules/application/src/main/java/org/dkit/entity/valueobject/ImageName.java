package org.dkit.entity.valueobject;

import lombok.Getter;

import javax.naming.InvalidNameException;

/**
 * ImageName represents the combination of
 * the image name and the image tag
 */
@Getter
public class ImageName {
    private final String name;
    private String tag = "latest";

    /**
     * @param name image name
     * @param tag image tag
     */
    public ImageName(final String name, final String tag) {
        this.name = name; this.tag = tag;
    }

    /**
     * @param name image name
     * when omitting the image tag the default image tag
     * "latest" will be used (similar behavior to docker)
     */
    public ImageName(final String name) {
        this.name = name;
    }

    /**
     * create image name object from the given String
     * @param imageNameAndTag String contains the image name and the image tag
     * the parameter imageNameAndTag should be formatted as follows:
     * imageName:imageTag
     * @return ImageName the created Image name
     * @throws InvalidNameException if the format of the given String not correct
     */
    public ImageName of(final String imageNameAndTag) throws InvalidNameException {
        var split = imageNameAndTag.split(":");
        if (split.length == 2) {
            return new ImageName(split[0], split[1]);
        } else if (split.length == 1) {
            return new ImageName(split[0]);
        } else {
            throw new InvalidNameException("image name is not valid");
        }
    }

    @Override
    public String toString() {
        return String.format("%s:%s", this.name, this.tag);
    }
}
