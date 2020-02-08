module venus.ddd.main {
    requires venus.utils;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    exports org.venuspj.ddd.model.entity;
    exports org.venuspj.ddd.model.repository;
    exports org.venuspj.ddd.model.repository.criteria;
    exports org.venuspj.ddd.model.values;
    exports org.venuspj.ddd.model.values.primitives;
    exports org.venuspj.ddd.model.values.primitives.code;
    exports org.venuspj.ddd.model.values.buisiness;
    exports org.venuspj.ddd.model.values.buisiness.address;
    exports org.venuspj.ddd.model.values.buisiness.contact;
    exports org.venuspj.ddd.model.values.buisiness.datetime;
    exports org.venuspj.ddd.model.values.buisiness.money;
    exports org.venuspj.ddd.model.values.buisiness.quantity;

}