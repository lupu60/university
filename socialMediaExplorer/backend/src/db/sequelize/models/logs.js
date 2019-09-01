'use strict';
module.exports = (sequelize, DataTypes) => {
  var logs = sequelize.define('logs', {
    id: {
      type: DataTypes.UUID,
      defaultValue: DataTypes.UUIDV4,
      allowNull: false,
      primaryKey: true
    },
    type: DataTypes.STRING,
    message: DataTypes.STRING,
    raw_value: DataTypes.JSON
  }, {
    classMethods: {
      associate: function(models) {
        // associations can be defined here
      }
    }
  });
  return logs;
};